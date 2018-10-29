package com.qcj.test;

import com.qcj.dao.impl.UserDaoImpl3;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
//cglib动态代理： 委托类（采用继承的方式）
public class CglibTest {
    public static void main(String[] args) {
        //1.创建委托类对象
        UserDaoImpl3 userDaoImpl3 = new UserDaoImpl3();
        //2.创建代理类对象
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(UserDaoImpl3.class);//给谁创建代理类就设置为他的子类
        //添加增强功能：拦截每个方法  参数Cellback接口实现类
        enhancer.setCallback(new MethodInterceptor() {
            /*拦截intercept
                     //proxy:代理类对象
                    //method:委托类对象 方法的描述对象 adduser描述对象 deleteuser描述对象
                    //args:方法的参数
                    //methodProxy：代理类方法
             */
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                System.out.println("开启事务");
                Object obj = method.invoke(userDaoImpl3,args);
                System.out.println("结束事务");
                return obj;
            }
        });
        UserDaoImpl3 proxy = (UserDaoImpl3) enhancer.create();

        //3.调用
        proxy.addUser();
        proxy.deleteUser();
    }
}
