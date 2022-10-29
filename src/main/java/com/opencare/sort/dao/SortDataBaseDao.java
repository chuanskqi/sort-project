package com.opencare.sort.dao;

import com.opencare.sort.dao.entity.SortDataBaseEntity;
import com.opencare.sort.service.SortDataEntityMapper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SortDataBaseDao<T extends SortDataBaseEntity> extends JpaRepository<T, Long> {

    /**
     * 获取dao与排序数据的映射关系，用于策略的自动注册与运行时匹配
     * 子类必须覆写该方法
     * @return
     */
    default SortDataEntityMapper getSortDataMapper() {
        //throw new UnsupportedOperationException("must impl getSortDataMapper method");
        return new SortDataEntityMapper() {
            @Override
            public Class<? extends Comparable> getSortDataClazz() {
                return null;
            }

            @Override
            public Class<? extends SortDataBaseEntity> getEntityClazz() {
                return SortDataBaseEntity.class;
            }
        };
    }
}
