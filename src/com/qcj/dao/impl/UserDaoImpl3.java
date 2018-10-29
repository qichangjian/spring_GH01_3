package com.qcj.dao.impl;

//jdk动态代理：接口+实现类 自动实现代理类
//不需要实现接口
public class UserDaoImpl3 {

    public void addUser() {
        System.out.println("add3");
    }

    public void deleteUser() {
        System.out.println("delete3");
    }
}
