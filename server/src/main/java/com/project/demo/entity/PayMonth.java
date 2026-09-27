package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 发薪月份：(PayMonth)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "PayMonth")
public class PayMonth implements Serializable {

    // PayMonth编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pay_month_id")
    private Integer pay_month_id;

    // 发薪月份
    @Basic
    private String pay_month;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
