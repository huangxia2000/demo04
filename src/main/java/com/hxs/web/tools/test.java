package com.hxs.web.tools;

import com.hxs.web.aop.SleepHelper;
import com.hxs.web.aop.Sleepble;
import com.hxs.web.entity.Dept;
import com.hxs.web.entity.Emp;
import com.hxs.web.entity.User;
import com.hxs.web.ioc.Computer;
import com.hxs.web.ioc.Person;
import com.hxs.web.mapper.DeptMapper;
import com.hxs.web.mapper.EmpMapper;
import com.hxs.web.mapper.UserMapper;
import com.hxs.web.web.LoginAction;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.TestExecutionListeners;

import java.util.List;

public class test {
    public static void main(String[] args) {
    new test().findUser();

    }
@Test
    public void findUser(){
        SqlSession session=MyBatisUtil.getSession();
        List<User> ulist= session.selectList("findUserAll");
        System.out.println(ulist.size());
    }
    @Test
    public void addUser(){
        SqlSession session=MyBatisUtil.getSession();
        User user=new User("admin1","123");
        int num=session.insert("addUser",user);
        session.commit();
        session.close();
    }
    @Test
    public void delUser(){
        SqlSession session=MyBatisUtil.getSession();
        User user=new User("admin1","123");
        int num=session.insert("addUser",user);
        session.commit();
        session.close();
    }
    @Test
    public void tt(){
        SqlSession session=MyBatisUtil.getSession();
        EmpMapper empMapper= session.getMapper(EmpMapper.class);
        Emp emp=empMapper.findUserById(new Integer(2));
    }

    @Test
    public void dept(){
        SqlSession session=MyBatisUtil.getSession();
        DeptMapper empMapper= session.getMapper(DeptMapper.class);
        Dept dept=empMapper.findDeptById(new Integer(2));
        List<Emp> depts=dept.getEmps();
        for (Emp emp:depts){
            System.out.println(emp.getEname());
        }
    }

    @Test
    public void rongqi(){

        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        Computer cp=ac.getBean("computer",Computer.class);
        System.out.println(cp.getCpu());

    }


    @Test
    public void rongqi1(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
/*      Computer cp=ac.getBean("computer1",Computer.class);*/
        Person man=ac.getBean("person",Person.class);
        List<String> ulist=man.getComputer().getUlist();
/*        for (String list:ulist) {
            System.out.println(list);
        }*/
        System.out.println(man.getComputer());
/*
        Computer cp=ac.getBean("com",Computer.class);
        System.out.println(cp.getCpu());*/
    }

    @Test
    public void aop(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext-add.xml");
       Sleepble sleep=( Sleepble)ac.getBean("TomDai");
       sleep.sleep();

    }

    @Test
    public void Log(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        LoginAction sleep=( LoginAction)ac.getBean("loginAction");
        sleep.execute();

    }

}

