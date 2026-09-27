package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 订单状态：(OrderSigning)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "OrderSigning")
public class OrderSigning implements Serializable {

    // OrderSigning编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_signing_id")
    private Integer order_signing_id;

    // 供应商编号
    @Basic
    private Integer supplier_no;
    // 订单号
    @Basic
    private String order_number;
    // 用户
    @Basic
    private Integer user;
    // 商品名称
    @Basic
    private String trade_name;
    // 购买数量
    @Basic
    private String purchase_quantity;
    // 收货人姓名
    @Basic
    private String consignee_name;
    // 联系电话
    @Basic
    private String contact_number;
    // 收房间号
    @Basic
    private String receive_room_number;
    // 订单状态
    @Basic
    private String order_status;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
