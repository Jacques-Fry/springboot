package com.jacques.common.mapper;

import com.jacques.common.pojo.WebsiteStatistics;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

/**
 * @author Jack_YD
 * @create 2019/12/10 11:40
 */
@Mapper
@Component
public interface WebsiteStatisticsMapper {
  /**
   * 新增网站信息
   */
  @Insert("Insert into website_statistics (id,name,visits,url) " +
      "values (#{WS.id},#{WS.name},#{WS.visits},#{WS.url})")
  void insert(@Param("WS") WebsiteStatistics websiteStatistics);


  /**
   * 修改网站信息
   */
  //修改名称地址
  @Update("update website_statistics set name=#{WS.name},url=#{WS.url} where id=#{WS.id}")
  void update(@Param("WS") WebsiteStatistics websiteStatistics);

  //浏览数+1
  @Update("update website_statistics set visits=visits+1 where id=#{id}")
  void AddVisits(@Param("id") String id);


  /**
   * 查询网站信息
   */
  //根据查询是否数据是否存在
  @Select("select count(1) from website_statistics where id=#{id}")
  Integer countById(@Param("id") String id);

  //查询全部数据
  @Select("select id,name,visits,url,create_time createTime from website_statistics where id=#{id}")
  WebsiteStatistics findById(@Param("id") String id);

  //查询浏览数
  @Select("select visits from website_statistics where id=#{id}")
  WebsiteStatistics findVisitsById(@Param("id") String id);
}
