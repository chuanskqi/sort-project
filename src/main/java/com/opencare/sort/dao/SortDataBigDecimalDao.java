package com.opencare.sort.dao;

import com.opencare.sort.dao.entity.SortDataBigDecimalEntity;
import com.opencare.sort.service.SortDataEntityMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface SortDataBigDecimalDao extends SortDataBaseDao<SortDataBigDecimalEntity> {
    @Override
    default SortDataEntityMapper getSortDataMapper() {
        return SortDataEntityMapper.BIGDECIMAL;
    }
}
