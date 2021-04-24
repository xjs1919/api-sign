package com.github.xjs.api.sign;


import com.alibaba.fastjson.annotation.JSONField;
import com.github.xjs.api.sign.checker.ApiSignChecker;
import com.github.xjs.api.sign.checker.SignFieldApiSignChecker;

/**
 * @author jiashuai.xu
 * @date 2021/4/16 10:02 上午
 */
public interface ApiSignAble {

    @JSONField(deserialize=false, serialize = false)
    default ApiSignChecker getSignChecker(){
        return new SignFieldApiSignChecker();
    }

    String getApiSign();

    String getApiRnd();

    Long getApiTimestamp();

}
