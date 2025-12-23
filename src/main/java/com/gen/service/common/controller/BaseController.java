package com.gen.service.common.controller;

import com.gen.service.common.exception.ApiError;
import com.gen.service.common.exception.ApiRest;
import com.gen.service.common.exception.GlobalException;
import org.springframework.stereotype.Component;

/**
 * Base Controller
 */
@Component
public class BaseController {

    /**
     * Message
     *
     * @param code    Code
     * @param message Message
     * @param data    Data
     * @param <T>     Type
     */
    protected <T> ApiRest<T> message(Integer code, String message, T data) {
        ApiRest<T> response = new ApiRest<>();
        response.setCode(code);
        response.setMessage(message);
        if (data != null) {
            response.setData(data);
        }
        return response;
    }

    /**
     * Success
     *
     * @param <T> Type
     */
    protected <T> ApiRest<T> success() {
        return message(0, ApiError.Success.message, null);
    }

    /**
     * Success
     *
     * @param message Message
     * @param data    Data
     * @param <T>     Type
     */
    protected <T> ApiRest<T> success(String message, T data) {
        return message(ApiError.Success.code, message, data);
    }

    /**
     * Success
     *
     * @param data Data
     * @param <T>  Type
     */
    protected <T> ApiRest<T> success(T data) {
        return message(ApiError.Success.code, ApiError.Success.message, data);
    }


    /**
     * Failure
     *
     * @param code    Code
     * @param message Message
     * @param data    Data
     * @param <T>     Type
     */
    protected <T> ApiRest<T> failure(Integer code, String message, T data) {
        return message(code, message, data);
    }

    /**
     * Failure
     *
     * @param message Message
     * @param data    Data
     * @param <T>     Type
     */
    protected <T> ApiRest<T> failure(String message, T data) {
        return message(ApiError.Failed.code, message, data);
    }

    /**
     * Failure
     *
     * @param message Message
     */
    protected <T> ApiRest<T> failure(String message) {
        return message(ApiError.Failed.code, message, null);
    }

    /**
     * Failure
     * <p>
     * * @param data Data
     *
     * @param <T> Type
     */
    protected <T> ApiRest<T> failure(T data) {
        return message(ApiError.Failed.code, ApiError.Failed.message, data);
    }

    /**
     * Failure
     *
     * @param <T> Type
     */
    protected <T> ApiRest<T> failure() {
        return message(ApiError.Failed.code, ApiError.Failed.message, null);
    }

    /**
     * Failure
     */
    protected <T> ApiRest<T> failure(ApiError error, T data) {
        return message(error.code, error.message, data);
    }

    /**
     *
     * @param ex  GlobalException
     * @param <T> Type
     */
    protected <T> ApiRest<T> failure(GlobalException ex) {
        return message(ex.getCode(), ex.getMessage(), null);
    }
}
