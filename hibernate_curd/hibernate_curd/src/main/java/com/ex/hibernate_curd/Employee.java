package com.ex.hibernate_curd;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
//@Table(name="emplo")
public class Employee {

 @Id
  //@GeneratedValue(strategy = GenerationType.AUTO)
  //@GeneratedValue(strategy = GenerationType.IDENTITY)
  int id;
  String fn;
  String ln;
  String Branch;
  
  
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getFn() {
    return fn;
  }
  public void setFn(String fn) {
    this.fn = fn;
  }
  public String getLn() {
    return ln;
  }
  public void setLn(String ln) {
    this.ln = ln;
  }
  public String getBranch() {
    return Branch;
  }
  public void setBranch(String branch) {
    Branch = branch;
  }
  
  
  
  
}