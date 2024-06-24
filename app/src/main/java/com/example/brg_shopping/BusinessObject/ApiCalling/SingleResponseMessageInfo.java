package com.example.brg_shopping.BusinessObject.ApiCalling;

public class SingleResponseMessageInfo<T> {
    private boolean isSuccess;
    private T item;
    private ErrorMessageInfo err;

    public SingleResponseMessageInfo() {
        isSuccess = false;
        err = new ErrorMessageInfo();
    }

    public SingleResponseMessageInfo(String message) {
        isSuccess = false;
        err = new ErrorMessageInfo("001", message);
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public ErrorMessageInfo getErr() {
        return err;
    }

    public void setErr(ErrorMessageInfo err) {
        this.err = err;
    }
}