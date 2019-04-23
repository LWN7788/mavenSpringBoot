package com.sunvua.ljy.response;

public class ReturnCommonType {
    private String status;
    private Object data;

    public static ReturnCommonType create(Object result){
        return ReturnCommonType.create(result,"success");
    }
    public static ReturnCommonType create(Object result,String status){
        ReturnCommonType type=new ReturnCommonType();
        type.setStatus(status);
        type.setData(result);
        return type;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
