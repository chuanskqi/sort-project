package com.opencare.sort.dao;

import com.opencare.sort.dao.entity.SortDataLongEntity;
import com.opencare.sort.service.SortDataEntityMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface SortDataLongDao extends SortDataBaseDao<SortDataLongEntity> {

    @Override
    default SortDataEntityMapper getSortDataMapper() {
        return SortDataEntityMapper.LONG;
    }

}
