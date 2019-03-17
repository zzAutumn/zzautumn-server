package com.yezi.zzautumn.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * @Author: yezi
 * @Date: 2019/3/16 08 49
 * @Description:
 */
@Entity
@Table(name = "image_urls")
@DynamicUpdate
@DynamicInsert
@Data
public class ImageUrl {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "image_url")
    private String imageUrl;

}
