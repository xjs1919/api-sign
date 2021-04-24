package com.github.xjs.api.sign;

import com.github.xjs.api.sign.advice.ApiSignCheckAdvice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jiashuai.xu
 * @date 2021/4/19 2:26 下午
 */
@Configuration
public class ApiSignCheckAutoConfiguration {

    @Bean
    public ApiSignCheckAdvice checkSignAdvice(){
        return new ApiSignCheckAdvice();
    }

}
