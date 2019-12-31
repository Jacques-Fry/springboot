package com.jacques.common.controller;

import com.jacques.common.pojo.WebsiteStatistics;
import com.jacques.common.returnStyle.JSONResult;
import com.jacques.common.service.WebsiteStatisticsService;
import com.jacques.common.utils.StatusUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Jack_YD
 * @create 2019/12/10 11:59
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/websiteStatistics")
public class WebsiteStatisticsController {

  @Autowired
  private WebsiteStatisticsService websiteStatisticsService;

  @PostMapping("addition")
  public JSONResult addition(@RequestBody WebsiteStatistics websiteStatistics) {
    return new JSONResult(true, StatusUtil.OK, "插入成功", websiteStatisticsService.insert(websiteStatistics));
  }

  @PutMapping("modification")
  public JSONResult modification(@RequestBody WebsiteStatistics websiteStatistics) {
    return new JSONResult(true, StatusUtil.OK, "修改成功", websiteStatisticsService.update(websiteStatistics));
  }

  @PutMapping("addVisits")
  public JSONResult addVisits(@RequestBody WebsiteStatistics websiteStatistics) {
    return new JSONResult(true, StatusUtil.OK, "添加成功", websiteStatisticsService.AddVisits(websiteStatistics.getId()));
  }

  @GetMapping("getData")
  public JSONResult getData(String id) {

    return new JSONResult(true, StatusUtil.OK, "查询成功", websiteStatisticsService.findById(id));
  }

  @GetMapping("getVisits")
  public JSONResult getVisits(String id) {
    return new JSONResult(true, StatusUtil.OK, "查询成功", websiteStatisticsService.findVisitsById(id));
  }

}
