package com.qcj.test;

import com.qcj.dao.UserDao;
import com.qcj.dao.impl.UserDaoImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *  jdk动态代理：接口+实现类 自动实现代理类
 */
public class ProxyTest {
    public static void main(String[] args) {
        //jdk动态代理：接口+实现类 自动实现代理类
        //1.创建委托类对象
        UserDao userDao = new UserDaoImpl();
        //2.生成代理对象(proxy在反射包中)
        //参数1：类加载器  参数2：委托类对象实现的接口 参数3：拦截器
        UserDao proxyDao = (UserDao)Proxy.newProxyInstance(
                ProxyTest.class.getClassLoader(),
                userDao.getClass().getInterfaces(),
                new InvocationHandler() { //拦截处理接口中方法
                    //proxy:代理类对象
                    //method:委托类对象 方法的描述对象 adduser描述对象 deleteuser描述对象
                    //args:方法的参数
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("开启事务");
                        //手动拦截每个方法
                        Object obj = method.invoke(userDao,args);//手动调用拦截的方法
                        System.out.println("关闭事务");
                        return obj;
                    }
                });
        //3.调用代理对象的方法
        proxyDao.addUser();
        proxyDao.deleteUser();
    }
}
