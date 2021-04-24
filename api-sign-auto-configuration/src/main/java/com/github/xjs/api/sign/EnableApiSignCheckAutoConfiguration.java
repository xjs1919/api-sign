package com.github.xjs.api.sign;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author jiashuai.xu
 * @date 2021/4/19 2:26 下午
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(ApiSignCheckAutoConfiguration.class)
public @interface EnableApiSignCheckAutoConfiguration {

}
