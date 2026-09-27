package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 客户消费记录：(CustomerConsumptionRecord)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "CustomerConsumptionRecord")
public class CustomerConsumptionRecord implements Serializable {

    // CustomerConsumptionRecord编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_consumption_record_id")
    private Integer customer_consumption_record_id;

    // 客户
    @Basic
    private Integer customer;
    // 用户姓名
    @Basic
    private String user_name;
    // 消费时间
    @Basic
    private Timestamp dissipate;
    // 消费金额
    @Basic
    private Integer consumption_amount;
    // 消费次数
    @Basic
    private String consumption_times;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
