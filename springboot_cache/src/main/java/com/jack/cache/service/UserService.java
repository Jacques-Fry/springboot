package com.jack.cache.service;

import com.jack.cache.bean.User;
import com.jack.cache.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author PC20
 * @create 2019/8/12
 */
@CacheConfig(cacheNames = "user")
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    /*1. @Cacheable的几个属性详解：
     *       cacheNames/value：指定缓存组件的名字
     *       key：缓存数据使用的key,可以用它来指定。默认使用方法参数的值，一般不需要指定
     *       keyGenerator：作用和key一样，二选一
     *       cacheManager和cacheResolver作用相同：指定缓存管理器，二选一
     *       condition：指定符合条件才缓存，比如：condition="#id>3"
     *                   也就是说传入的参数id>3才缓存数据
     *      unless：否定缓存，当unless为true时不缓存，可以获取方法结果进行判断
     *      sync：是否使用异步模式*/
    //@Cacheable(value = {"user"},keyGenerator = "MyKeyGenerator",condition = "#a0>0",unless = "#result==null")
    @Cacheable(/*value = "user",*/key="#id",unless = "#result==null")
    public User getUser(Integer id){
        System.out.println("进入查询方法-"+id);
        return userMapper.getUser(id);
    }


    /**
     * CachePut 既调用方法,同时更新缓存
     * @param user
     * @return
     */
    @CachePut(/*value="user",*/key="#result.id",unless="#result==null")
    public User updateUser(User user){
        int i=userMapper.updateUser(user);
        if(i!=1){
            return null;
        }
        System.out.println("进入更新-"+user.getId());
        return user;
    }

    /**
     * CacheEvict 缓存清除
     */
    @CacheEvict(/*value = "user",*/key="#id")
    public void delUser(Integer id){
        userMapper.delectUser(id);
        System.out.println("进入删除-"+id);
    }
}
