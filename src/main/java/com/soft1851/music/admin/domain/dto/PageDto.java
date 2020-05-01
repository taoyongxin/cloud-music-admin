package com.soft1851.music.admin.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * @author Tao
 * @version 1.0
 * @ClassName PageDto
 * @Description TODO
 * @date 2020-04-21 23:40
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageDto {
    private Object field;

    @NotNull(message = "当前页码数不能为空")
    @Max(value = 500,message = "当前页码大于500")
    private int currentPage;


    @NotNull(message = "每页显示页数数据数不能为空")
    @Max(value = 20,message = "每页条数大于20条")
    private int pageSize;
}

