package com.sunvua.ljy.controller.error;

public interface CommonError {
    public int getErrorCode();
    public String getErrorMsg();
    public CommonError setErrorMsg(String errorMsg);
}
