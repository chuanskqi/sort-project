package com.opencare.sort.dto;

import java.util.List;
import lombok.Data;

@Data
public class SortDto<T> {

    private List<T> data;

    private String order = "asc";

}
