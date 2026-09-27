package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 员工工资：(EmployeeSalary)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "EmployeeSalary")
public class EmployeeSalary implements Serializable {

    // EmployeeSalary编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_salary_id")
    private Integer employee_salary_id;

    // 员工工号
    @Basic
    private Integer employee_no;
    // 员工姓名
    @Basic
    private String employee_name;
    // 发薪月份
    @Basic
    private String salary_month;
    // 基本工资
    @Basic
    private Integer base_pay;
    // 加班工资
    @Basic
    private Integer overtime_wage;
    // 奖金
    @Basic
    private Integer bonus;
    // 请假天数
    @Basic
    private String leave_days;
    // 旷班天数
    @Basic
    private String days_of_absenteeism;
    // 罚款
    @Basic
    private Integer fine;
    // 考勤扣款
    @Basic
    private Integer attendance_deduction;
    // 实发工资
    @Basic
    private String net_salary;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
