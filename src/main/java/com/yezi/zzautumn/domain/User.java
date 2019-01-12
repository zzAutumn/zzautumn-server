package com.yezi.zzautumn.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: yezi
 * @Date: 2019/1/12 12 31
 * @Description:
 */
@Entity
@Table(name = "user")
@DynamicUpdate
@DynamicInsert
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    @Column
    private String password;

    @Column(name = "create_date")
    private Date createDate = new Date();

    @Column(name = "update_date")
    private Date updateDate = new Date();
}
