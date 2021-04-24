package com.github.xjs.api.sign.advice;


import com.github.xjs.api.sign.ApiSignCheck;
import com.github.xjs.api.sign.ApiSignAble;
import com.github.xjs.api.sign.checker.ApiSignChecker;
import com.github.xjs.api.sign.exception.ApiSignCheckException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * @author jiashuai.xu
 * @date 2021/4/16 11:25 上午
 */
@Aspect
public class ApiSignCheckAdvice {

    @Around("@annotation(apiSignCheck)")
    public Object execute(ProceedingJoinPoint joinPoint, ApiSignCheck apiSignCheck) throws Throwable {
        Object args[] = joinPoint.getArgs();
        if(args.length <= 0){
            throw new ApiSignCheckException("方法参数不能为空");
        }
        boolean find = false;
        for(Object arg : args){
            if(ApiSignAble.class.isAssignableFrom(arg.getClass())){
                checkSign((ApiSignAble)arg);
                find = true;
            }
        }
        if(!find){
            throw new ApiSignCheckException("至少一个参数必须实现com.github.xjs.api.sign.SignAble接口");
        }
        return joinPoint.proceed();
    }

    private void checkSign(ApiSignAble apiSignAble){
        ApiSignChecker apiSignChecker = apiSignAble.getSignChecker();
        if(apiSignChecker == null){
            throw new ApiSignCheckException("signChecker不能为空");
        }
        if(!apiSignChecker.checkSign(apiSignAble)){
            throw new ApiSignCheckException("签名非法");
        }
    }
}
