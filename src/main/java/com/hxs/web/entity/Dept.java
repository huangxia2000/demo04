package com.hxs.web.entity;

import java.util.List;

public class Dept {
 private Integer   dno;
 private String  dname;
 private List<Emp> emps;

 public List<Emp> getEmps() {
  return emps;
 }

 public void setEmps(List<Emp> emps) {
  this.emps = emps;
 }

 public Dept() {
 }

 public Integer getDno() {
  return dno;
 }

 public void setDno(Integer dno) {
  this.dno = dno;
 }

 public String getDname() {
  return dname;
 }

 public void setDname(String dname) {
  this.dname = dname;
 }
}
