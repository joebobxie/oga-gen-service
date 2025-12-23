package com.gen.service.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * The base class for responses
 * with content (string)
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Base class for responses", description="The base class for responses")
public class BaseStringVO extends BaseVO {
    
    /**
     * Content
     */
    @ApiModelProperty(value = "Content")
    private String content;
    
    /**
     * Class Overloading
     *
     */
    public BaseStringVO() {
    }
    
    /**
     * Class Overloading
     *
     * @param content Content
     */
    public BaseStringVO(String content) {
        this.content = content;
    }
}
