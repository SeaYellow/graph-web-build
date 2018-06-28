package com.authority.enumUtil;

/**
 * Created by merit on 2018/2/6.
 */
public enum AuthorityActionEnum {
    LOGIN("LOGIN"), LOGOUT("LOGOUT"), UNAUTHORIZED("UNAUTHORIZED"), LOGIN_VALIDATE("LOGIN_VALIDATE");


    private String value;

    AuthorityActionEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
