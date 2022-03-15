package com.atguigu.mybatis_plus_demo;

import com.atguigu.mybatis_plus_demo.entity.User;
import com.atguigu.mybatis_plus_demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.yaml.snakeyaml.events.Event;

import java.util.List;

@SpringBootTest
class MybatisPlusDemoApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void findAll() {
        List<User> userList = userMapper.selectList(null);
        userList.forEach(user -> {
            System.out.println(user.toString());
        });
        //System.out.println(userList);
    }

}
