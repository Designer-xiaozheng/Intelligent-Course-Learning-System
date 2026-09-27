package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 商品零售：(CommodityRetail)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "CommodityRetail")
public class CommodityRetail implements Serializable {

    // CommodityRetail编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commodity_retail_id")
    private Integer commodity_retail_id;

    // 供应商编号
    @Basic
    private Integer supplier_no;
    // 订单号
    @Basic
    private String order_number;
    // 商品编号
    @Basic
    private String article_no;
    // 商品名称
    @Basic
    private String trade_name;
    // 品牌
    @Basic
    private String brand;
    // 规格
    @Basic
    private String specifications;
    // 价格
    @Basic
    private String price;
    // 用户
    @Basic
    private Integer user;
    // 购买数量
    @Basic
    private Integer purchase_quantity;
    // 总价格
    @Basic
    private String total_price;
    // 收货人姓名
    @Basic
    private String consignee_name;
    // 联系电话
    @Basic
    private String contact_number;
    // 房间号
    @Basic
    private String room_number;
    // 备注
    @Basic
    private String remarks;




    // 支付状态
    @Basic
    private String pay_state;

    // 支付类型: 微信、支付宝、网银
    @Basic
    private String pay_type;










    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
