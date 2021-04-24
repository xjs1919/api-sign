package com.github.xjs.api.sign.checker;

import com.alibaba.fastjson.JSON;
import com.github.xjs.api.sign.ApiSignAble;
import com.github.xjs.api.sign.ApiSignField;
import com.github.xjs.api.sign.exception.ApiSignCheckException;
import com.github.xjs.api.sign.util.DateUtil;
import com.github.xjs.api.sign.util.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @author jiashuai.xu
 * @date 2021/4/16 10:23 上午
 */
public class SignFieldApiSignChecker implements ApiSignChecker {

    private static Logger log = LoggerFactory.getLogger(SignFieldApiSignChecker.class);

    @Override
    public boolean checkSign(ApiSignAble apiSignAble) {
        if(StringUtils.isEmpty(apiSignAble.getApiSign())){
            throw new ApiSignCheckException("签名不能为空");
        }
        String signCalc = calcSign(apiSignAble);
        return signCalc.equals(apiSignAble.getApiSign());
    }

    @Override
    public String calcSign(final ApiSignAble apiSignAble){
        //固定参数
        checkParams(apiSignAble);
        //业务参数
        List<SignFieldInfo> values = new ArrayList<>();
        ReflectionUtils.doWithFields(apiSignAble.getClass(), new ReflectionUtils.FieldCallback(){
            @Override
            public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
                field.setAccessible(true);
                ApiSignField apiSignField = field.getAnnotation(ApiSignField.class);
                if(apiSignField == null){
                    return;
                }
                Object filedValue = field.get(apiSignAble);
                if(filedValue != null){
                    SignFieldInfo filedInfo = new SignFieldInfo();
                    filedInfo.setOrder(apiSignField.value());
                    filedInfo.setValue(filedValue);
                    values.add(filedInfo);
                }
            }
        });
        Collections.sort(values, new Comparator<SignFieldInfo>() {
            @Override
            public int compare(SignFieldInfo o1, SignFieldInfo o2) {
                return o1.getOrder()-o2.getOrder();
            }
        });

        String src = "";

        //首先是时间戳里面的年月日时分
        String ymdHm = DateUtil.format(new Date(apiSignAble.getApiTimestamp()),"yyyyMMddHHmm");
        src += ymdHm;

        //然后是随机数
        String rnd = apiSignAble.getApiRnd();
        src += rnd;

        //然后是业务参数
        for(SignFieldInfo fieldInfo : values){
            Object value = fieldInfo.getValue();
            if(ClassUtils.isPrimitiveOrWrapper(value.getClass()) || value.getClass() == String.class){
                src += value.toString();
            }else{
                src += JSON.toJSONString(value);
            }
        }

        // 计算md5
        String calc = MD5Util.md5(src);
        log.info("request param:{}, sign src:{}, sign result:{}", JSON.toJSONString(apiSignAble), src, calc);
        return calc;
    }

    private void checkParams(ApiSignAble apiSignAble) {
        String rnd = apiSignAble.getApiRnd();
        if(StringUtils.isEmpty(rnd)){
            throw new ApiSignCheckException("随机串不能为空");
        }
        Long timestamp = apiSignAble.getApiTimestamp();
        if(timestamp == null){
            throw new ApiSignCheckException("时间戳不能为空");
        }
        //时间戳不能超过5分钟
        Long now = System.currentTimeMillis();
        if(Math.abs(now - timestamp) > 5L * 60 * 1000 ){
            throw new ApiSignCheckException("签名非法，时间戳错误");
        }
    }
}
