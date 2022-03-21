package com.atguigu.mybatis_plus_demo.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by WXHang on HANG at 2022/3/16 14:44
 * @author HANG
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * mp 执行添加的时候这个方法执行
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        Date date = new Date();
        this.setFieldValByName("createTime",date,metaObject);
        this.setFieldValByName("updateTime",date,metaObject);
        this.setFieldValByName("version",1,metaObject);
        this.setFieldValByName("delete",0,metaObject);
    }

    /**
     * mp 执行修改的时候这个方法执行
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime",new Date(),metaObject);
        this.setFieldValByName("delete",1,metaObject);
    }
}