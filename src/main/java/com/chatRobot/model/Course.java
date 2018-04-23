package com.chatRobot.model;

/**
 * Created In Ctrip. <br/>
 *
 * @author: liangyf <br/>
 * @date: 2018/4/23 <br/>
 */
public class Course {

  private int id;
  private String name;
  private int credit;

  public Course(){

  }

  public Course(int id,String name,int credit){
    this.id=id;
    this.name=name;
    this.credit=credit;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getCredit() {
    return credit;
  }

  public void setCredit(int credit) {
    this.credit = credit;
  }



}
