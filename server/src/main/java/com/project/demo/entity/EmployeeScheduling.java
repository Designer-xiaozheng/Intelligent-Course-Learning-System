package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 员工排班：(EmployeeScheduling)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "EmployeeScheduling")
public class EmployeeScheduling implements Serializable {

    // EmployeeScheduling编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_scheduling_id")
    private Integer employee_scheduling_id;

    // 员工工号
    @Basic
    private Integer employee_no;
    // 员工姓名
    @Basic
    private String employee_name;
    // 排班月份
    @Basic
    private String shift_month;
    // 排班情况
    @Basic
    private String shift_arrangement;
    // 请假情况
    @Basic
    private String leave_situation;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
