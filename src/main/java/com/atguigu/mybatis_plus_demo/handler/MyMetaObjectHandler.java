package com.atguigu.mybatis_plus_demo.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

/**
 * Created by WXHang on HANG at 2022/3/16 14:44
 * @author HANG
 */
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * mp 执行添加的时候这个方法执行
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {

    }

    /**
     * mp 执行修改的时候这个方法执行
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {

    }
}