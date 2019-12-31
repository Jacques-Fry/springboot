package com.jacques.common.service;

import com.jacques.common.exception.CommonException;
import com.jacques.common.mapper.WebsiteStatisticsMapper;
import com.jacques.common.pojo.WebsiteStatistics;
import com.jacques.common.utils.IdWorker;
import com.jacques.common.utils.StatusUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Jack_YD
 * @create 2019/12/10 11:49
 */
@Service
public class WebsiteStatisticsService {
  @Autowired
  private WebsiteStatisticsMapper websiteStatisticsMapper;


  /**
   * 插入网站数据
   *
   * @param websiteStatistics
   * @return
   */
  @Transactional
  public WebsiteStatistics insert(WebsiteStatistics websiteStatistics) {

    if (StringUtils.isBlank(websiteStatistics.getName()) || StringUtils.isBlank(websiteStatistics.getUrl()))
      throw new CommonException(StatusUtil.PARAM_ERROR, "参数错误");

    if (StringUtils.isBlank(websiteStatistics.getId()))
      //生成ID
      websiteStatistics.setId(new IdWorker().nextId() + "");
    else {
      //验证ID
      if (websiteStatisticsMapper.countById(websiteStatistics.getId()) > 0)
        throw new CommonException(StatusUtil.PARAM_ERROR, "ID已存在");
    }
    websiteStatistics.setVisits(0);
    websiteStatisticsMapper.insert(websiteStatistics);

    return websiteStatisticsMapper.findById(websiteStatistics.getId());
  }


  /**
   * 修改网站数据
   */
  //修改名称地址
  @Transactional
  public WebsiteStatistics update(WebsiteStatistics websiteStatistics) {
    if (StringUtils.isBlank(websiteStatistics.getId()) || StringUtils.isBlank(websiteStatistics.getName()) || StringUtils.isBlank(websiteStatistics.getUrl()))
      throw new CommonException(StatusUtil.PARAM_ERROR, "参数错误");

    //验证ID
    if (websiteStatisticsMapper.countById(websiteStatistics.getId()) == 0)
      throw new CommonException(StatusUtil.PARAM_ERROR, "数据不存在");

    websiteStatisticsMapper.update(websiteStatistics);

    return websiteStatisticsMapper.findById(websiteStatistics.getId());
  }

  //浏览数+1
  @Transactional
  public WebsiteStatistics AddVisits(String id) {
    if (StringUtils.isBlank(id))
      throw new CommonException(StatusUtil.PARAM_ERROR, "参数错误");

    //验证ID
    if (websiteStatisticsMapper.countById(id) == 0)
      throw new CommonException(StatusUtil.PARAM_ERROR, "数据不存在");

    websiteStatisticsMapper.AddVisits(id);

    return websiteStatisticsMapper.findVisitsById(id);
  }


  /**
   * 查询数据
   */
  //查询网站全部数据
  public WebsiteStatistics findById(String id) {
    if (StringUtils.isBlank(id))
      throw new CommonException(StatusUtil.PARAM_ERROR, "参数错误");

    //验证ID
    if (websiteStatisticsMapper.countById(id) == 0)
      throw new CommonException(StatusUtil.PARAM_ERROR, "数据不存在");

    return websiteStatisticsMapper.findById(id);
  }

  //查询网站浏览数
  public WebsiteStatistics findVisitsById(String id) {
    if (StringUtils.isBlank(id))
      throw new CommonException(StatusUtil.PARAM_ERROR, "参数错误");

    return websiteStatisticsMapper.findVisitsById(id);
  }
}
