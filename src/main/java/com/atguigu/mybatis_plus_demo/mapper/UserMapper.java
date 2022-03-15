package com.atguigu.mybatis_plus_demo.mapper;

import com.atguigu.mybatis_plus_demo.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * @Author: HANG
 * @Date: 2022/3/15 15:09
 * @Desc:
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
}
