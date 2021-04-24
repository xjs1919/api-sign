package comn.test.controller;

import com.alibaba.fastjson.JSON;
import com.github.xjs.api.sign.exception.ApiSignCheckException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jiashuai.xu
 * @date 2021/4/19 3:15 下午
 */
@ControllerAdvice
public class DemoExceptionHandler {

    @ExceptionHandler(ApiSignCheckException.class)
    @ResponseBody
    public String signCheckException(ApiSignCheckException ex) {
        return ex.getMessage();
    }

}
