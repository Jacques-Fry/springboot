package com.jacques.common.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Jack_YD
 * @create 2019/12/10 11:54
 */

public class WebsiteStatistics implements Serializable{
  private String id;

  private String name;

  private Integer visits;

  private String url;

  private Date createTime;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getVisits() {
    return visits;
  }

  public void setVisits(Integer visits) {
    this.visits = visits;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public WebsiteStatistics(String id, String name, Integer visits, String url) {
    this.id = id;
    this.name = name;
    this.visits = visits;
    this.url = url;
  }

  public WebsiteStatistics() {
  }

}
