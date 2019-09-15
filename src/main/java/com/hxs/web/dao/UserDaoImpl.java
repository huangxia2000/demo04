package com.hxs.web.dao;

import com.hxs.web.entity.User;
import com.hxs.web.tools.DbHelper;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements  UserDao {
    private Connection conn = null;
    private String sql = null;
    private ResultSet rs = null;
    private PreparedStatement pstate = null;
    private boolean flag = false;
    private List list = null;

// QueryRunner

    @Override
    public User findUserByUser(User user) {
        try {
            String sql="select * from user where  uname=? and upwd=?";
            QueryRunner qr=DbHelper.getQueryRunner();
            Object [] params=new Object[]{user.getUname(),user.getUpwd()};
            user=(User) qr.query(sql,params, new BeanHandler<>(User.class));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return user;
    }
    // 登入
    @Override
    public boolean add(String name, String much, String type)
    {
        boolean flag=true;
        try {
            String sql="insert into ku (sid,kuid,shangid,name,much,type) values (kux.nextval,kux.nextval,kux.nextval,?,?,?)";
            QueryRunner qr= DbHelper.getQueryRunner();
            Object [] params=new Object[]{name,much,type};
            int unm=qr.update(sql, params);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flag;
    }

}
