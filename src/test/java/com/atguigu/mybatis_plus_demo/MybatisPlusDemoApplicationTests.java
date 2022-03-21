package com.atguigu.mybatis_plus_demo;

import com.atguigu.mybatis_plus_demo.entity.User;
import com.atguigu.mybatis_plus_demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class MybatisPlusDemoApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void addTest(){
        User user = new User();
        user.setEmail("3124723678@qq.com");
        user.setAge(28);
        //user.setId(6L);
        user.setName("yaozhjueqi22o934");
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }

    @Test
    public void findAll() {
        List<User> userList = userMapper.selectList(null);
        userList.forEach(user -> {
            System.out.println(user.toString());
        });
        //System.out.println(userList);

    }
    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(6L);
        user.setName("yaozhoujueqi111111111");
        int count = userMapper.updateById(user);
        System.out.println(count);
    }

    @Test
    public void testOptimisticLocker(){
        User user = userMapper.selectById("1505752155892572161");
        user.setName("乐观锁测试");
        //user.setVersion(user.getVersion()+1);
        userMapper.updateById(user);
    }

    /**
     * 多个id批量查询
     */
    @Test
    public void testSelect1(){
        List<User> userList = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        /*userList.forEach(user ->
                        System.out.println(user.toString()));*/
        for (User user : userList) {
            System.out.println(user);
        }
    }

}
