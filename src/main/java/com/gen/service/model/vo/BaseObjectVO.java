package com.gen.service.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * The base class for responses
 * with content (object)
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Base class for responses", description="The base class for responses")
public class BaseObjectVO extends BaseVO {

    /**
     * Content
     */
    @ApiModelProperty(value = "Content")
    private Object content;


    /**
     * Class Overloading
     *
     */
    public BaseObjectVO() {
    }

    /**
     * Class Overloading
     *
     * @param content Content
     */
    public BaseObjectVO(String content) {
        this.content = content;
    }
}
