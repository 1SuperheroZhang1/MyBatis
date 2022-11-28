package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.SelectMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class SelectMapperTest {

    /**
     * MyBatis的各种查询功能：
     * 1、若查询出的数据只有一条
     * a> 可以通过实体类对象接收
     * b> 可以通过list集合接收
     * c> 可以通过map集合接收
     * 结果：{password=123456, sex=男, id=2, age=23, email=12345@qq.com, username=admin}
     * 2、若查询出的数据有多条
     * a> 可以通过实体类类型的list集合接收
     * b> 可以通过map类型的list集合接收
     * c> 可以在mapper接口的方法上添加@MapKey注解，此时就可以将每条数据转换为map集合作为值，以某个字段的值作为键
     *  注意：一定不能通过实体类对象接收，此时会抛异常TooManyResultException
     *  MyBatis中设置了默认的类型别名：
     *  java.lang.Integer --> int,integer
     *  int --> _int,_integer
     *  Map --> map
     *  String --> string
     * */

    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> list = mapper.getAllUser();
        list.forEach(user -> System.out.println(user));
    }

    @Test
    public void testGetUserById(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        User user = mapper.getUserById(2);
        System.out.println(user);
    }

    @Test
    public void testGetCount(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Integer count = mapper.getCount();
        System.out.println(count);
    }

    @Test
    public void testGetUserByIdToMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> map = mapper.getUserByIdToMap(2);
        System.out.println(map);
    }

    @Test
    public void testGetAllUserToMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
//        List<Map<String, Object>> list = mapper.getAllUserToMap();
//        System.out.println(list);
        Map<String, Object> map = mapper.getAllUserToMap();
        System.out.println(map);
    }
}
