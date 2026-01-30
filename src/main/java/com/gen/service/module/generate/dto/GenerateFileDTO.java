package com.gen.service.module.generate.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class GenerateFileDTO {
    /**
     * Path
     */
    @ApiModelProperty(value = "Path")
    private String path;

    /**
     * File Name
     */
    @ApiModelProperty(value = "File Name")
    private String fileName;

    /**
     * Tag
     */
    @ApiModelProperty(value = "Tag")
    private String tag;
}
