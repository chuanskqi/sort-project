package com.opencare.sort.controller.dto;

import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class SortDataDto<T> {

    /**
     * 排序对象集合
     */
    @NotEmpty
    @Size(min = 1)
    private List<T> data;

    // 默认升序
    private String order = "asc";

}
