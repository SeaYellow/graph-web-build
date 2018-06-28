package com.authority.enumUtil;

/**
 * Created by merit on 2018/2/6.
 */
public enum AuthorityErrorCodeEnum {
    USER_PASSWORD_EMPTY(1, "username or password is empty."), UNKNOWN_ACCOUNT(2, "unknown account."), INCORRECT_CREDENTIALS(3, "incorrect password."), LOCKED_ACCOUNT(4, "account locked."), EXCESSIVE_ATTEMPTS(5, "excessive attempts."), AUTHENTICATION_ERROR(6, "authentication error.");

    int code;
    String errorMsg;

    AuthorityErrorCodeEnum(int code, String errorMsg) {
        this.code = code;
        this.errorMsg = errorMsg;
    }

    public int getCode() {
        return code;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

}
