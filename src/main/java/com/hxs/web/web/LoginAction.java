package com.hxs.web.web;
import com.hxs.web.aoplog.Log;
import com.hxs.web.biz.UserBiz;
import com.hxs.web.biz.UserBizlmpl;
import com.hxs.web.entity.User;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginAction implements SessionAware {

    private User user;
    private List<User> ulist;
    private Map<String,Object> session=new HashMap<>();
    @Resource
    private UserBiz userBiz;

 /*   @Log(LogType = "登入" ,LogName = "用户登入")*/
    public String  execute (){
        String remsg = "no";
        User loginU =  userBiz.login(user.getUname(),user.getUpwd());
        if(null !=loginU ){
/*          session.put("user",loginU);
            List list=new ArrayList();
            list.add("111");
            list.add("222");
            user.setUlist(list);
            session.put("ulist",list);*/
            remsg = "ok";
        }
        return remsg;
    }

/*    public String  execute (){
        String remsg = "no";
        User loginU =  userBiz.login(user.getUname(),user.getUpwd());
        if(null !=loginU ){
*//*          session.put("user",loginU);
            List list=new ArrayList();
            list.add("111");
            list.add("222");
            user.setUlist(list);
            session.put("ulist",list);*//*
            remsg = "ok";
        }
        return remsg;
    }*/


        //得到session对象
//         Map<String,Object>  maps=ActionContext.getContext().getSession();
//         HttpSession session = ServletActionContext.getRequest().getSession();
//         session.setAttribute("user",loginU);



    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }



    @Override
    public void setSession(Map<String, Object> map) {
        System.out.println("map = [" + map + "]");
        session=map;
    }
}
