package com.jacques.shiro.shiro;

import com.jacques.shiro.shiro.filter.ShiroLoginFilter;
import com.jacques.shiro.shiro.realm.PermissionRealm;
import com.jacques.shiro.shiro.session.CustomSessionManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Jack_YD
 * @create 2019/12/23 16:37
 */
@Configuration
public class ShiroConfiguration {

  //1.创建realm
  @Bean
  public PermissionRealm getPermissionRealm() {
    return new PermissionRealm();
  }

  //2.创建安全管理器
  @Bean
  public SecurityManager getSecurityManager(PermissionRealm permissionRealm) {
    DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
    securityManager.setRealm(permissionRealm);
    //注册自定义会话管理器
    securityManager.setSessionManager(sessionManager());
    //注册自定义redis缓存管理器
    securityManager.setCacheManager(redisCacheManager());
    return securityManager;
  }

  //3.配置shiro的过滤器工厂
  @Bean
  public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
    //1.创建过滤器工厂
    ShiroFilterFactoryBean filterFactory = new ShiroFilterFactoryBean();
    //2.设置安全管理器
    filterFactory.setSecurityManager(securityManager);
    //3.通用配置(授权登陆页面,授权跳转页面)
    //用户未登录不进行跳转，而是自定义返回json数据
    Map<String, Filter> filters = filterFactory.getFilters();
    filters.put("authc", new ShiroLoginFilter());//将自定义 的FormAuthenticationFilter注入shiroFilter中
//    filterFactory.setLoginUrl("/noLogin");
//    filterFactory.setUnauthorizedUrl("/noAuth");
    //4.设置过滤器集合
    Map<String, String> map = new LinkedHashMap<>();
    map.put("/user/login", "anon");
    map.put("/noLogin", "anon");
    map.put("/noAuth", "anon");
//    map.put("/**", "authc");
    //map.put("/user/home","perms[user:home]");//是否具备权限,建议使用注解

    filterFactory.setFilterChainDefinitionMap(map);

    return filterFactory;

  }

  /**
   * 开启Shiro的注解(如@RequiresRoles,@RequiresPermissions),需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证
   * 配置以下两个bean(DefaultAdvisorAutoProxyCreator和AuthorizationAttributeSourceAdvisor)即可实现此功能
   */
  @Bean
  public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
    DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
    advisorAutoProxyCreator.setProxyTargetClass(true);
    return advisorAutoProxyCreator;
  }

  //开启对shiro注解的支持
  @Bean
  public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
    AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
    advisor.setSecurityManager(securityManager);
    return advisor;
  }

  @Value("${spring.redis.host}")
  private String host;
  @Value("${spring.redis.port}")
  private Integer port;
  @Value("${custom.redisExpire}")
  private Integer redisExpire;

  //1.redis的控制器
  public RedisManager redisManager() {
    RedisManager redisManager = new RedisManager();
    redisManager.setHost(host);
    redisManager.setPort(port);
    return redisManager;
  }

  //2.sessionDao
  public RedisSessionDAO redisSessionDAO() {
    RedisSessionDAO sessionDAO = new RedisSessionDAO();
    sessionDAO.setRedisManager(redisManager());
    sessionDAO.setExpire(redisExpire);
    return sessionDAO;
  }

  //3.会话管理器
  public DefaultWebSessionManager sessionManager() {
    CustomSessionManager sessionManager = new CustomSessionManager();
    sessionManager.setSessionDAO(redisSessionDAO());
    //禁用cookie
    sessionManager.setSessionIdCookieEnabled(false);
    //禁用url重写
    sessionManager.setSessionIdUrlRewritingEnabled(false);
    return sessionManager;
  }

  //4.缓存管理器
  public RedisCacheManager redisCacheManager() {
    RedisCacheManager redisCacheManager = new RedisCacheManager();
    redisCacheManager.setRedisManager(redisManager());
    return redisCacheManager;
  }


}
