package com.opencare.sort.service;

import com.opencare.sort.dao.entity.SortDataBaseEntity;
import com.opencare.sort.dao.entity.SortDataBigDecimalEntity;
import com.opencare.sort.dao.entity.SortDataLongEntity;
import com.opencare.sort.dao.entity.SortDataStringEntity;
import java.math.BigDecimal;

/**
 * 记录数据 实体 映射关系
 */
public interface SortDataEntityMapper {
    /**
     * 获取排序数据类型
     */
    Class<? extends Comparable> getSortDataClazz();

    /**
     * 基础类型映射实体类
     * @return
     */
    Class<? extends SortDataBaseEntity> getEntityClazz();

    // string ~ 对象 关系
    SortDataEntityMapper STRING = new SortDataEntityMapper() {
        @Override
        public Class<? extends Comparable> getSortDataClazz() {
            return String.class;
        }
        @Override
        public Class<? extends SortDataBaseEntity> getEntityClazz() {
            return SortDataStringEntity.class;
        }
    };

    // Long ~ 对象 关系
    SortDataEntityMapper LONG = new SortDataEntityMapper() {
        @Override
        public Class<? extends Comparable> getSortDataClazz() {
            return Long.class;
        }
        @Override
        public Class<? extends SortDataBaseEntity> getEntityClazz() {
            return SortDataLongEntity.class;
        }
    };

    // BigDecimal ~ 对象 关系
    SortDataEntityMapper BIGDECIMAL = new SortDataEntityMapper() {
        @Override
        public Class<? extends Comparable> getSortDataClazz() {
            return BigDecimal.class;
        }
        @Override
        public Class<? extends SortDataBaseEntity> getEntityClazz() {
            return SortDataBigDecimalEntity.class;
        }
    };

}
