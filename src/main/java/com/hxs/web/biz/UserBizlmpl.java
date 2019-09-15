package com.hxs.web.biz;


import   com.hxs.web.entity.User;
import com.hxs.web.mapper.UserMapper;
import com.hxs.web.tools.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
@Service("userBiz")
public class UserBizlmpl implements  UserBiz{
    @Resource
    private UserMapper userMapper;

    @Override
    public User login(String uname, String upwd) {
/*      qlSession session= MyBatisUtil.getSession();
        UserMapper userMapper= session.getMapper(UserMapper.class);*/
         Map<String,Object> umap=new HashMap<String,Object>();
         umap.put("uname",uname);
         umap.put("upwd",upwd);
        return userMapper.findUserByName(umap);
    }
}
