package com.hxs.web.tools;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MyBatisUtil {
    private static String conf="SqlMapConfig.xml";
    public static SqlSession getSession(){
        Reader reader= null;
        try {
            reader = Resources.getResourceAsReader(conf);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactoryBuilder sfb=new SqlSessionFactoryBuilder();
        SqlSessionFactory sf=  sfb.build(reader);
        return sf.openSession();
    }
}
