package com.qcj.dao.impl;

import com.qcj.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public void addUser() {
        System.out.println("add");
    }

    @Override
    public void deleteUser() {
        System.out.println("delete");
    }
}
