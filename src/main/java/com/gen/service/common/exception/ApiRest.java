package com.gen.service.common.exception;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Interface response
 */
@Data
@NoArgsConstructor
@ApiModel(value="Interface response", description="Interface response")
public class ApiRest<T> {

    /**
     * Response Message
     */
    @ApiModelProperty(value = "Response Message")
    private String message;

    /**
     * Response Code
     */
    @ApiModelProperty(value = "Response Code", required = true)
    private Integer code;

    /**
     * Response Data
     */
    @ApiModelProperty(value = "Response Data")
    protected T data;

    /**
     * 是否成功
     *
     */
    public boolean isSuccess() {
        return code.equals(1);
    }

    /**
     * Class Overloading Constructor
     *
     * @param exception GlobalException
     */
    public ApiRest(GlobalException exception) {
        this.code = exception.getCode();
        this.message = exception.getMessage();
    }

    /**
     * Class Overloading Constructor
     * @param error ApiError
     */
    public ApiRest(ApiError error) {
        this.code = error.code;
        this.message = error.message;
    }

    /**
     * Class Overloading Constructor
     */
    public ApiRest(Integer code) {
        this.code = code;
    }
}