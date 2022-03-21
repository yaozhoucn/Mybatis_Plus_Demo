package com.atguigu.mybatis_plus_demo;

import com.atguigu.mybatis_plus_demo.entity.User;
import com.atguigu.mybatis_plus_demo.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class MybatisPlusDemoApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void addTest(){
        User user = new User();
        user.setEmail("31247erer23678@qq.com");
        user.setAge(28);
        //user.setId(6L);
        user.setName("yaozhereqi22o934");
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

    /**
     * 多个条件查询
     */
    @Test
    public void testSelect2(){
        HashMap<String, Object> map = new HashMap<>();
        //map 是抽象的，无法实例化
        map.put("name","Jone");
        map.put("age","18");
        List<User> userList = userMapper.selectByMap(map);
        System.out.println(userList);
    }
    /**
     * 分页查询测试
     */
    @Test
    public void testSelectPage(){
        Page<User> page = new Page(1, 3);
        Page<User> userList = userMapper.selectPage(page, null);
        System.out.println(userList);
        /*long current = page.getCurrent();
        List<User> records = page.getRecords();
        long pages = page.getPages();
        long total = page.getTotal();
        long size = page.getSize();*/
        long pages = page.getPages(); //总页数
        long current = page.getCurrent(); //当前页
        List<User> records = page.getRecords(); //查询数据集合
        long total = page.getTotal(); //总记录数
        boolean hasNext = page.hasNext();  //下一页
        boolean hasPrevious = page.hasPrevious(); //上一页
        System.out.println(pages);
        System.out.println(current);
        System.out.println(records);
        System.out.println(total);
        System.out.println(hasNext);
        System.out.println(hasPrevious);

    }
    @Test
    public void testDeleteById(){
        int result = userMapper.deleteById(5L);
        System.out.println(result);
    }

    @Test
    public void testDeleteBatchIds() {
        int result = userMapper.deleteBatchIds(Arrays.asList(8, 9, 10));
        System.out.println(result);
    }

    @Test
    public void testDeleteByMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "Helen");
        map.put("age", 18);
        int result = userMapper.deleteByMap(map);
        System.out.println(result);
    }

    /**
     * 逻辑删除测试
     */
    @Test
    public void testLogicDelete() {
        int result = userMapper.deleteById(2L);
        System.out.println(result);
    }
}
