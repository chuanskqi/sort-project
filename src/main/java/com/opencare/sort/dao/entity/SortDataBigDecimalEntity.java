package com.opencare.sort.dao.entity;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "t_sort_data_bigdecimal")
@Data
public class SortDataBigDecimalEntity extends SortDataBaseEntity<BigDecimal> {
}
