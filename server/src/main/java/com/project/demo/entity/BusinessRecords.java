package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 营业记录：(BusinessRecords)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "BusinessRecords")
public class BusinessRecords implements Serializable {

    // BusinessRecords编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "business_records_id")
    private Integer business_records_id;

    // 月份
    @Basic
    private String month;
    // 营业日期
    @Basic
    private Timestamp business_date;
    // 营业额
    @Basic
    private Integer turnover;
    // 客户人数
    @Basic
    private String number_of_customers;
    // 营业情况
    @Basic
    private String business_situation;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
