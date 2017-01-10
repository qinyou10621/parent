package com.utils.imageIdentifying;

import java.io.Serializable;

public class JsonResult<T> implements Serializable {
	private static final long serialVersionUID = -2903321682635191204L;
	private static final int SUCCESS = 0;
	private static final int ERROR = 1;
	private int state;
	private String message;
	private T data;

	public JsonResult(int state, String message, T data) {
		this.state = state;
		this.message = message;
		this.data = data;
	}

	public JsonResult(Throwable e) {
		this(ERROR, e.getMessage(), null);
	}

	public JsonResult(String error) {
		this(ERROR, error, null);
	}

	public JsonResult(T data) {
		this(SUCCESS, "", data);
	}

	public JsonResult() {
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "JsonResult [state=" + state + ", message=" + message + ", data=" + data + "]";
	}

}
