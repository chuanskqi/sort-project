package com.opencare.sort.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class SortService {

    public <T> List<T> sortAndSaveDb(List<T> data, String type) {
        List<T> sort = sort(data, type);
        return sort;
    }

    private <T> List<T> sort(List<T> data, String type) {
        Comparator<? super T> comparator = StringUtils.equals("asc", type)
            ? (Comparator<? super T>) Comparator.naturalOrder()
            : (Comparator<? super T>) Comparator.reverseOrder();
        return data.stream().sorted(comparator).collect(Collectors.toList());
    }
}
