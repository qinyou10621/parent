package com.utils;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/12/28 0028.
 */
public class JsonResult<T> implements Serializable {

    private static final int ERROR = 1;
    private static final int SUCCESS = 0;
    private static final long serialVersionUID = 8094294379179571429L;
    private int status;
    private String message;
    private T data;

    public JsonResult(Throwable e) {
        this(ERROR, e.getMessage(), null);

    }

    public JsonResult(T data) {
        this(SUCCESS, "", data);
    }

    public JsonResult(String errorMessage) {
        this(ERROR, errorMessage, null);
    }

    public JsonResult(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public JsonResult() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
