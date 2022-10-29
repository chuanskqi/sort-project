package com.opencare.sort.service;

import com.opencare.sort.dao.SortDataBaseDao;
import com.opencare.sort.dao.entity.SortDataBaseEntity;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;


/**
 * SortDataDao根据数据类型,委派请求到具体实现
 */
@Service
@AllArgsConstructor
public class SortDataDaoDelegateService implements InitializingBean {

    // 发现全部Dao实现
    final List<SortDataBaseDao> sortDataBaseDaos;

    // 根据数据class 找对应的DAO
    Map<Class, SortDataBaseDao> clazz2SortDataMap;

    // 根据数据class 找entity
    Map<Class, Class<? extends SortDataBaseEntity>> clazz2EntityMap;

    @Override
    public void afterPropertiesSet() throws Exception {
        // 自动注册 clazz ~ dao关系
        clazz2SortDataMap = sortDataBaseDaos.stream().collect(Collectors.toMap(
            sortDataBaseDao -> sortDataBaseDao.getSortDataMapper().getSortDataClazz(),
            Function.identity()));

        // 自动注册 clazz ~ entity关系
        clazz2EntityMap = sortDataBaseDaos.stream().collect(Collectors.toMap(
            sortDataBaseDao -> sortDataBaseDao.getSortDataMapper().getSortDataClazz(),
            sortDataBaseDao -> sortDataBaseDao.getSortDataMapper().getEntityClazz()));
    }

    public <T> SortDataBaseEntity newEntity(Class<T> dataType) {
        Class<? extends SortDataBaseEntity> clazz = clazz2EntityMap.get(dataType);
        if (clazz == null) {
            throw new UnsupportedOperationException("not exist dataType:" + dataType.getName());
        }
        try {
            return clazz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("init clazz error", e);
        }
    }

    /**
     * 保存排序后的实体对象到数据库
     * @param list
     */
    public void saveAll(List<SortDataBaseEntity> list) {
        if (!CollectionUtils.isEmpty(list)) {
            findDao(list.get(0).getData().getClass()).saveAll(list);
        }
    }

    /**
     * 根据不同类型对应的表中查全量的排序数据
     * @param clazz
     */
    public List<SortDataBaseEntity> findAll(Class<?> clazz) {
        return findDao(clazz).findAll();
    }


    private SortDataBaseDao findDao(Class<?> clazz) {
        SortDataBaseDao sortDataBaseDao = clazz2SortDataMap.get(clazz);
        if (sortDataBaseDao == null) {
            throw new UnsupportedOperationException("not exist dataType:" + clazz.getName());
        }
        return sortDataBaseDao;
    }
}
