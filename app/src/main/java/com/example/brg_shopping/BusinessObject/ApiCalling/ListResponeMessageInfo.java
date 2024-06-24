package com.example.brg_shopping.BusinessObject.ApiCalling;

import java.util.ArrayList;
import java.util.List;

public class ListResponeMessageInfo<T> {

    private boolean IsSuccess;

    private int TotalRecords;

    private List<T> Data;

    private ErrorMessageInfo Err;

    public ListResponeMessageInfo() {
        Err = new ErrorMessageInfo();
        Data = new ArrayList<>();
    }

    public boolean isSuccess() {
        return IsSuccess;
    }

    public void setSuccess(boolean success) {
        IsSuccess = success;
    }

    public int getTotalRecords() {
        return TotalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        TotalRecords = totalRecords;
    }

    public List<T> getData() {
        return Data;
    }

    public void setData(List<T> data) {
        Data = data;
    }

    public ErrorMessageInfo getErr() {
        return Err;
    }

    public void setErr(ErrorMessageInfo err) {
        Err = err;
    }
}

