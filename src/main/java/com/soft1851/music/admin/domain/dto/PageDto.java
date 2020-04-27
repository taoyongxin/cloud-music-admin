package com.soft1851.music.admin.domain.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author Tao
 * @version 1.0
 * @ClassName PageDto
 * @Description TODO
 * @date 2020-04-21 23:40
 **/
@Data
@Builder
public class PageDto {
    private Object field;
    private int currentPage;
    private int pageSize;
}

