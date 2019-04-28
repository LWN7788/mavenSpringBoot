package com.sunvua.ljy.error;

public enum EmBusinessError implements CommonError {
    USER_NOT_EXIST(10001,"用户不存在"),
    UNKNOWN_ERROE(10002,"未知错误")
    ;
    private EmBusinessError(int errCode,String errMsg){
        this.errCode=errCode;
        this.errMsg=errMsg;
    }
    private int errCode;
    private String errMsg;
    @Override
    public int getErrorCode() {
        return this.errCode;
    }

    @Override
    public String getErrorMsg() {
        return this.errMsg;
    }

    @Override
    public CommonError setErrorMsg(String errorMsg) {
        this.errMsg=errorMsg;
        return this;
    }
}