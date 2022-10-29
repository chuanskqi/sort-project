package com.opencare.sort.dao;

import com.opencare.sort.dao.entity.SortDataStringEntity;
import com.opencare.sort.service.SortDataEntityMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface SortDataStringDao extends SortDataBaseDao<SortDataStringEntity> {

    @Override
    default SortDataEntityMapper getSortDataMapper() {
        return SortDataEntityMapper.STRING;
    }
}
