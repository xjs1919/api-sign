package com.github.xjs.api.sign.exception;

/**
 * @author jiashuai.xu
 * @date 2021/4/16 11:21 上午
 */
public class ApiSignCheckException extends RuntimeException{

    public ApiSignCheckException(){

    }

    public ApiSignCheckException(String msg){
        super(msg);
    }

    public ApiSignCheckException(Throwable t){
        super(t);
    }

}
