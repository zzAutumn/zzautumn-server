package com.yezi.zzautumn.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: yezi
 * @Date: 2019/1/6 13 25
 * @Description:
 */
@Entity
@Table(name = "articles")
@DynamicUpdate
@DynamicInsert
@Data
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer articleId;

    @Column
    private String title;

    @Column
    private String content;

    @Column(name = "create_date")
    private Date createDate = new Date();

    @Column(name = "update_date")
    private Date updateDate = new Date();

    @Column(name = "assign_tags")
    private String assignTags;
}
