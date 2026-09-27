package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 棋牌房间：(ChessAndCardRoom)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "ChessAndCardRoom")
public class ChessAndCardRoom implements Serializable {

    // ChessAndCardRoom编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chess_and_card_room_id")
    private Integer chess_and_card_room_id;

    // 房间名称
    @Basic
    private String room_name;
    // 房间类型
    @Basic
    private String room_type;
    // 房间数量
    @Basic
    private Integer number_of_rooms;
    // 图片
    @Basic
    private String picture;
    // 价格
    @Basic
    private Integer price;
    // 房间设施
    @Basic
    private String room_facilities;
    // 房间介绍
    @Basic
    private String room_introduction;

    // 点击数
    @Basic
    private Integer hits;

    // 点赞数
    @Basic
    private Integer praise_len;












    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
