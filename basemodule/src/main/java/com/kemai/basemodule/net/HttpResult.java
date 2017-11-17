package com.kemai.basemodule.net;

import java.io.Serializable;

/**
 * @author mark.liu
 *         网络请求结果格式
 */
public class HttpResult<T> implements Serializable {
    private int code;

    private String msg;

    private T result;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}