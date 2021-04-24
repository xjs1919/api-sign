package com.github.xjs.api.sign.checker;

/**
 * @author jiashuai.xu
 * @date 2021/4/16 10:33 上午
 */
public class SignFieldInfo {
    private int order;
    private Object value;

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
