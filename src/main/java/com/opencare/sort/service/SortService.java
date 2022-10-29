package com.opencare.sort.service;

import com.opencare.sort.dao.entity.SortDataBaseEntity;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SortService {

    final SortDataDaoDelegate dataDelegateDaoService;

    // 从1开始排序
    static final long START_ORDER_ID = 1;
    /**
     * 排序并保存数据
     * @param datas 待排序数据集合
     * @param type asc升序 desc降序
     * @return 排序后的数据集合
     */
    public <T> List<T> sortAndSave(List<T> datas, String type) {
        List<SortDataBaseEntity> entities = datas.stream()
            .distinct().map(data -> {   // todo distinct ?
                SortDataBaseEntity entity = dataDelegateDaoService.newEntity(data.getClass());
                entity.setData((Comparable) data);
                return entity;
        }).collect(Collectors.toList());

        // 设置元素排序前的序号
        setOrderId(entities, (entity, orderId) -> entity.setBefore(orderId));

        // 默认升序排序
        Collections.sort(entities);
        if (StringUtils.equals("desc", type)) {
            // 支持倒序
            Collections.reverse(entities);
        }

        // 设置元素排序后的序号
        setOrderId(entities, (entity, orderId) -> entity.setAfter(orderId));

        // 将排序前后结果 保存到数据库
        saveAll(entities);

        // 返回数据
        return entities.stream().map(entity -> (T) entity.getData()).collect(Collectors.toList());
    }

    /**
     * 使用模板模式复用代码 设置对象排序编号
     */
    private void setOrderId(List<SortDataBaseEntity> entities, BiConsumer<SortDataBaseEntity, Long> consumer) {
        long orderId = START_ORDER_ID;
        for (SortDataBaseEntity entity : entities) {
            consumer.accept(entity, orderId);
            orderId ++;
        }
    }

    private void saveAll(List<SortDataBaseEntity> sortDataList) {
        dataDelegateDaoService.saveAll(sortDataList);
    }

    public List<SortDataBaseEntity> findAll(Class<?> clazz) {
        return dataDelegateDaoService.findAll(clazz);
    }
}
