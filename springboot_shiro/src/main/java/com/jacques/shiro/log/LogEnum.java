package com.jacques.shiro.log;

/**
 * @author Jack_YD
 * @create 2019/12/20 15:12
 */
public enum LogEnum {
  BUSSINESS("bussiness"), PLATFORM("platform"), DB("db"), EXCEPTION("exception");
  private String category;
  LogEnum(String category){
    this.category=category;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }
}
