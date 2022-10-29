package com.opencare.sort.controller.dto;

import java.util.List;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class SortDataDto<T> {

    /**
     * 排序对象集合
     */
    @NotEmpty
    private List<T> data;

    // 默认升序
    private String order = "asc";

}
