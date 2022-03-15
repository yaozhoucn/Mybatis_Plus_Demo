package com.atguigu.mybatis_plus_demo.entity;

import lombok.Data;

/**
 * @Author: HANG
 * @Date: 2022/3/15 14:45
 * @Desc:
 */
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
