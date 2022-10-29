package com.opencare.sort.controller;

import com.opencare.sort.controller.dto.BaseResponse;
import com.opencare.sort.controller.dto.SortDataDto;
import com.opencare.sort.dao.entity.SortDataBaseEntity;
import com.opencare.sort.service.SortService;
import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/sort/data")
public class SortController {

    final SortService sortService;

    /**
     * 对数据进行排序，并保存到数据库
     * @param sortDataDto 排序对象
     * @return 排序后的对象
     */
    @RequestMapping(path = "/sort", method = RequestMethod.POST)
    public <T> BaseResponse<SortDataDto<T>> sort(@RequestBody SortDataDto<T> sortDataDto) {
        List<T> sortedData = sortService.sortAndSave(sortDataDto.getData(), sortDataDto.getOrder());
        sortDataDto.setData(sortedData);
        return BaseResponse.ok(sortDataDto);
    }

    /**
     * 查询所有string类型排序历史
     * @return
     */
    @RequestMapping(path = "/view/string", method = RequestMethod.GET)
    public BaseResponse<List<SortDataBaseEntity>> allString() {
        return BaseResponse.ok(sortService.findAll(String.class));
    }

    /**
     * 查询所有long类型排序历史
     * @return
     */
    @RequestMapping(path = "/view/long", method = RequestMethod.GET)
    public BaseResponse<List<SortDataBaseEntity>> allLong() {
        return BaseResponse.ok(sortService.findAll(Long.class));
    }

    /**
     * 查询所有bigdecimal类型排序历史
     * @return
     */
    @RequestMapping(path = "/view/bigdecimal", method = RequestMethod.GET)
    public BaseResponse<List<SortDataBaseEntity>> allBigDecimal() {
        return BaseResponse.ok(sortService.findAll(BigDecimal.class));
    }
}
