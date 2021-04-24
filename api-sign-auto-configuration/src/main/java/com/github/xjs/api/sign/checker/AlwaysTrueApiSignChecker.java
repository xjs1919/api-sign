package com.github.xjs.api.sign.checker;


import com.github.xjs.api.sign.ApiSignAble;

/**
 * @author jiashuai.xu
 * @date 2021/4/16 10:23 上午
 */
public class AlwaysTrueApiSignChecker implements ApiSignChecker {
    @Override
    public boolean checkSign(ApiSignAble apiSignAble) {
        return true;
    }

    @Override
    public String calcSign(ApiSignAble singAble) {
        return null;
    }
}
