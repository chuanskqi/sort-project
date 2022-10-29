package com.opencare.sort.dao.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "t_sort_data_string")
@Data
public class SortDataStringEntity extends SortDataBaseEntity<String> {

}
