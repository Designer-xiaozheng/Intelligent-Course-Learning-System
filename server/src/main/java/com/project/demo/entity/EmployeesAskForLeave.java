package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 请假申请：(EmployeesAskForLeave)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "EmployeesAskForLeave")
public class EmployeesAskForLeave implements Serializable {

    // EmployeesAskForLeave编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employees_ask_for_leave_id")
    private Integer employees_ask_for_leave_id;

    // 员工工号
    @Basic
    private Integer employee_no;
    // 员工姓名
    @Basic
    private String employee_name;
    // 请假类型
    @Basic
    private String leave_type;
    // 开始时间
    @Basic
    private Timestamp start_time;
    // 结束时间
    @Basic
    private Timestamp end_time;
    // 请假时长
    @Basic
    private Integer leave_duration;
    // 请假原因
    @Basic
    private String reason_for_leave;



    // 审核状态
    @Basic
    private String examine_state;








    // 审核回复
    @Basic
    private String examine_reply;



    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
