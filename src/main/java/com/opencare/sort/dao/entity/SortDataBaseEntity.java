package com.opencare.sort.dao.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass   // 子类可继承
@Data
public class SortDataBaseEntity<T extends Comparable> implements Comparable<SortDataBaseEntity> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 标识唯一请求号 TODO
    // private long requestId;

    /**
     * 排序数据
     */
    @Column
    private T data;

    // 排序前数据对应的序号
    @Column
    private Long before;

    // 排序后数据对应的序号
    @Column
    private Long after;

    @Override
    public int compareTo(SortDataBaseEntity o) {
        return this.getData().compareTo(o.getData());
    }
}
