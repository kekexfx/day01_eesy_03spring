package com.itheima.ui;

import com.itheima.dao.IAccountDao;
import com.itheima.service.IAccountService;
import com.itheima.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {
    /*
    * 获取Spring的核心容器，并根据id获取对象
    * ApplicationContext的三个常用实现类
    *   1.ClassPathXmlApplicationContext：可以加载类路径下的配置文件，配置文件必须在类路径下。不在的话，加载不了
    *   2.FileSystemXmlApplicationContext:可以用于加载磁盘任意路径下的配置文件（必须有访问权限）
    *   3.AnnotationConfigApplicationContext:可以用于读取注解创建容器
    *
    * 核心容器的两个接口，引发出的问题
    * ApplicationContext：适用于单例对象，更多采用这个接口定义实例对象
    *       它在构建核心容器时的策略是采用立即加载的方式，也就是说，只要一读取完配置文件，就立即进行创建
    * BeanFactory：适用于多例对象
    *       它在构建核心容器时的策略是采用延迟加载的方式。也就是说，什么时候根据id获取对象了，什么时候才真正的创建对象
    *
    * */

    public static void main(String[] args) {
        //1.获取核心容器对象
        //ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext ac = new FileSystemXmlApplicationContext("E:\\bimface_backend\\day01_eesy_03spring\\src\\main\\resources\\bean.xml");
        //2.根据id获取bean对象
        IAccountService as = (IAccountService)ac.getBean("accountService");
        IAccountDao adao = ac.getBean("accountDao",IAccountDao.class);

        System.out.println(as);

        System.out.println(adao);



        as.saveAccount();


    }
}
