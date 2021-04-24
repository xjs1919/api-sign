package com.test;

import comn.test.vo.DemoVo;

/**
 * @author jiashuai.xu
 * @date 2021/4/19 2:58 下午
 */
public class ApiSignUtil {
    public static void main(String[] args) {
        DemoVo vo = new DemoVo();
        vo.setName("Joshua");
        vo.setAge(30);
        vo.setApiRnd("123456");
        vo.setApiTimestamp(System.currentTimeMillis());
        String sign = vo.getSignChecker().calcSign(vo);
        System.out.println(vo.getApiTimestamp());
        System.out.println(sign);
    }
}
