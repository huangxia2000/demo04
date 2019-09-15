package com.hxs.web.ioc;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
/*@Component("com")*/
@Component
public class Computer {
    private String cpu="Cpu I5";
    private String price;
    private List ulist;
    private Map map;



    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public List getUlist() {
        return ulist;
    }

    public void setUlist(List ulist) {
        this.ulist = ulist;
    }

    public Computer(String cpu, String price) {
        this.cpu = cpu;
        this.price = price;
    }

    public Computer() {
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
