package com.sunvua.ljy.controller.error;

public class BusinessExcepiton extends Exception implements CommonError {
    private CommonError commonError;
    public BusinessExcepiton(CommonError commonError){
        super();
        this.commonError=commonError;
    }
    public BusinessExcepiton(CommonError commonError,String errMsg){
        super();
        this.commonError=commonError;
        this.commonError.setErrorMsg(errMsg);
    }
    @Override
    public int getErrorCode() {
        return this.commonError.getErrorCode();
    }

    @Override
    public String getErrorMsg() {
        return this.commonError.getErrorMsg();
    }

    @Override
    public CommonError setErrorMsg(String errorMsg) {
        this.commonError.setErrorMsg(errorMsg);
        return this;
    }
}
