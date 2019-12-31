package com.jack.cache.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author PC20
 * @create 2019/8/13
 */
@Mapper
public interface ObjectMapper {

    @Select("select * from user where id =#{id}")
    public Object getView(Integer id);

}
