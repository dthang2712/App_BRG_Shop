package com.example.brg_shopping.BusinessObject.ApiCalling;

import java.io.Serializable;

public class ApiResponseInfo<T> implements Serializable {

    /**
     * The data returned by the API.
     */
    private T data;

    /**
     * The raw content of the response, in case of parsing errors.
     */
    private String content;

    /**
     * A message associated with the response.
     */
    private String message;

    /**
     * Indicates whether the request was successful.
     */
    private boolean isSuccess;

    /**
     * Constructor for ApiResponse.
     */
    public ApiResponseInfo() {
    }

    /**
     * Constructor for ApiResponse with data.
     *
     * @param data The data to be set.
     */
    public ApiResponseInfo(T data) {
        this.data = data;
    }

    /**
     * Gets the data.
     *
     * @return The data.
     */
    public T getData() {
        return data;
    }

    /**
     * Sets the data.
     *
     * @param data The data to be set.
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Gets the raw content of the response.
     *
     * @return The raw content.
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the raw content of the response.
     *
     * @param content The raw content to be set.
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Gets the message associated with the response.
     *
     * @return The message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message associated with the response.
     *
     * @param message The message to be set.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets whether the request was successful.
     *
     * @return True if the request was successful, false otherwise.
     */
    public boolean isSuccess() {
        return isSuccess;
    }

    /**
     * Sets whether the request was successful.
     *
     * @param isSuccess True if the request was successful, false otherwise.
     */
    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }
}