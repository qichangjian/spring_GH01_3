package com.qcj.test;

import com.qcj.dao.UserDao;
import com.qcj.dao.impl.UserDaoImpl;
import com.qcj.dao.proxy.ProxyUserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *   代理：
 * 在添加用户方法调用前后都插入业务
 *
 * 真实处理的类（委托类）/代理类   （实现同一个几口）
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        //静态代理
        ProxyUserDao proxyUserDao = new ProxyUserDao(new UserDaoImpl());
        proxyUserDao.addUser();
        proxyUserDao.deleteUser();
    }
}
