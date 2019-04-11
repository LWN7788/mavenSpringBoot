package com.sunvua.ljy.model;

/**
 * http json 响应实体
 */
public class JsonResult {

    private boolean success;        // 是否成功
    private int error;              // 错误码
    private String message;         // 信息
    private Object data;            // 数据
    private long total;             // 总数(用于分页数据)

    public JsonResult(boolean success, String message){
        this.success = success;
        this.message = message;
    }

    public JsonResult(boolean success, String message, Object data){
        this(success, message);
        this.data = data;
    }

    public JsonResult(boolean success, String message, Object data, long total){
        this(success, message, data);
        this.total = total;

    }

    public JsonResult(boolean success, int error, String message){
        this.success = success;
        this.error = error;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
