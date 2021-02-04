package com.example.demo.service.dairy.Do;

/**
 * @author Jagi
 * @Date 2020/10/12
 */

public class Result<T> {
    public Boolean success;
    public T data;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
