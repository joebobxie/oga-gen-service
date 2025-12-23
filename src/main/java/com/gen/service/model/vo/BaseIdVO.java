package com.gen.service.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * The base class for responses
 * with primary key ID
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Base class for responses", description="The base class for responses with primary key ID")
public class BaseIdVO extends BaseVO {

    /**
     * ID
     */
    @ApiModelProperty(value = "Id")
    private String id;

    /**
     * Class Overloading
     */
    public BaseIdVO() {
    }
    /**
     * 重载
     * @param id ID
     */
    public BaseIdVO(String id) {
        this.id = id;
    }
}
