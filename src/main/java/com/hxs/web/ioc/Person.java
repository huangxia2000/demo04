package com.hxs.web.ioc;

import javafx.beans.NamedArg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Person {

    private String uname;
/*    @Named("com")*/
/*    @Resource//ref引用，初始化电脑（set。get的方法）*/

    @Autowired
    private Computer computer;

    public Person() {
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }
}
