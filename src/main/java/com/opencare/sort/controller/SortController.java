package com.opencare.sort.controller;

import com.opencare.sort.dto.BaseResponse;
import com.opencare.sort.dto.SortDto;
import com.opencare.sort.service.SortService;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
public class SortController {

    final SortService sortService;

    @RequestMapping(path = "/sort", method = RequestMethod.POST)
    public <T> BaseResponse<SortDto<T>> sort(@RequestBody SortDto<T> sortDto) {
        List<T> sortedData = sortService.sortAndSaveDb(sortDto.getData(), sortDto.getOrder());
        sortDto.setData(sortedData);
        return BaseResponse.ok(sortDto);
    }
}
