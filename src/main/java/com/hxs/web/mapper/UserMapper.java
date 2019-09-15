package com.hxs.web.mapper;

import com.hxs.web.aoplog.Log;
import com.hxs.web.entity.User;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@Repository
public interface UserMapper {

    public List<User> fidUserAll(List ulist);

    public void addUser(User user);

    @Log(LogType = "登入" ,LogName = "用户登入")
    public User findUserByName(Map<String,Object> map);
}
