package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 员工旷班：(EmployeeAbsenteeism)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "EmployeeAbsenteeism")
public class EmployeeAbsenteeism implements Serializable {

    // EmployeeAbsenteeism编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_absenteeism_id")
    private Integer employee_absenteeism_id;

    // 员工工号
    @Basic
    private Integer employee_no;
    // 员工姓名
    @Basic
    private String employee_name;
    // 旷班日期
    @Basic
    private Timestamp date_of_absenteeism;
    // 旷班时间
    @Basic
    private String absenteeism_time;
    // 旷班情况
    @Basic
    private String absenteeism;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
