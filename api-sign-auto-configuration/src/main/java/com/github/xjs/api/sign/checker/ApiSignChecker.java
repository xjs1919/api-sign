package com.github.xjs.api.sign.checker;


import com.github.xjs.api.sign.ApiSignAble;

/**
 * @author jiashuai.xu
 * @date 2021/4/16 10:20 上午
 */
public interface ApiSignChecker<T extends ApiSignAble> {

    boolean checkSign(T signAble);

    String calcSign(T singAble);

}
