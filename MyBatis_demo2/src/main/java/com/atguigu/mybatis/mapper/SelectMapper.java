package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SelectMapper {

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     * */
    User getUserById(@Param(value="id") Integer id);

    /**
     * 查询所有的用户信息
     * @return
     * */
    List<User> getAllUser();

    /**
     * 查询用户信息的总记录数
     * @return
     * 在MyBatis中，对于Java中常用的类型都设置了类型别名
     * 例如：java.lang.Integer --> int|integer
     * 例如：int --> _int|_integer
     * 例如：Map --> map,List --> list
     * */
    Integer getCount();

    /**
     * 根据id查询用户信息为一个map集合
     * @param id
     * @return
     * */
    Map<String,Object> getUserByIdToMap(@Param(value="id") Integer id);

    /**
     * 查询所有用户信息为map集合
     * @return
     * 将表中的数据以map集合的方式查询，一条数据对应一个map；
     * 若有多条数据，就会产生多个map集合，此时可以将这些map放在一个list集合中获取
     * */
//    List<Map<String,Object>> getAllUserToMap();
    @MapKey(value="id")
     Map<String,Object> getAllUserToMap();
}
