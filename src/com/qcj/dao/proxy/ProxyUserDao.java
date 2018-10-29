package com.qcj.dao.proxy;

import com.qcj.dao.UserDao;
import com.qcj.dao.impl.UserDaoImpl;

/**
 * 代理类
 */
public class ProxyUserDao implements UserDao {
    UserDao dao; //委托类对象

    public ProxyUserDao(UserDao dao) { //代理不只是代理一个委托类
        this.dao = dao;
    }

    @Override
    public void addUser() {
        System.out.println("开始事务");
        dao.addUser();
        System.out.println("结束事务");
    }

    @Override
    public void deleteUser() {
        System.out.println("开始事务");
        dao.deleteUser();
        System.out.println("结束事务");
    }
}
