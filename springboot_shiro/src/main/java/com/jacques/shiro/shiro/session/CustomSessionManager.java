package com.jacques.shiro.shiro.session;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;

/**
 * @author Jack_YD
 * @create 2019/12/24 14:14
 */
public class CustomSessionManager extends DefaultWebSessionManager {

  protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
    String id = WebUtils.toHttp(request).getHeader("Authorization");
    if (StringUtils.isNotBlank(id)) {
      request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE, "header");//来源
      request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, id);
      request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);//是否验证
      return id;
    } else {
      //没有生成新的sessionId
      return super.getSessionId(request, response);
    }
  }

}
