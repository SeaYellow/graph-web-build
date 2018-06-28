package com.common.utils;

/**
 * Created by Administrator on 2017/5/13.
 */
public enum ResponseStatus {
    OK(0), FAILURE(-1);

    private int value;

    ResponseStatus(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
