package com.opencare.sort.dao.entity;


import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "t_sort_data_long")
@Data
public class SortDataLongEntity extends SortDataBaseEntity<Long> {

}
