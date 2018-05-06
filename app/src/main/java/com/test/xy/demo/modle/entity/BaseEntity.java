package com.test.xy.demo.modle.entity;

/**
 * 网络请求返回的基本的实例
 */

public class BaseEntity<T> {
    /**
     * code : 0
     * msg : 请求成功
     */
    private String status;
    private String message;
    private String error;
    private T data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", error='" + error + '\'' +
                '}';
    }
}
