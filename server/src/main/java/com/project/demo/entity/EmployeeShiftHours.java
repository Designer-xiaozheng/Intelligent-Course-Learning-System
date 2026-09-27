package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 员工班时：(EmployeeShiftHours)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "EmployeeShiftHours")
public class EmployeeShiftHours implements Serializable {

    // EmployeeShiftHours编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_shift_hours_id")
    private Integer employee_shift_hours_id;

    // 员工工号
    @Basic
    private Integer employee_no;
    // 员工姓名
    @Basic
    private String employee_name;
    // 上班日期
    @Basic
    private Timestamp date_of_work;
    // 排班班次
    @Basic
    private String shift_arrangement;
    // 班时
    @Basic
    private String shift_hours;
    // 是否请假
    @Basic
    private String leave_or_not;
    // 是否旷班
    @Basic
    private String absenteeism_or_not;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
