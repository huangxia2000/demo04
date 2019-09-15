package com.hxs.web.entity;

public class Emp {
 private Integer   eno;
 private String  ename;
 private  Integer  dno;
 private Dept dept;


 public Emp() {
 }

 public  Integer  getDno() { return dno; }

 public void setDno( Integer  dno) { this.dno = dno; }

 public Integer getEno() {
  return eno;
 }

 public void setEno(Integer eno) {
  this.eno = eno;
 }

 public String getEname() {
  return ename;
 }

 public void setEname(String ename) {
  this.ename = ename;
 }

 public Dept getDept() {
  return dept;
 }

 public void setDept(Dept dept) {
  this.dept = dept;
 }
}
