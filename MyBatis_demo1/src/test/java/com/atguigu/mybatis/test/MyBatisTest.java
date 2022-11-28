package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.UserMapper;
import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class MyBatisTest {

    /**
     * SqlSession默认不自动提交事务，若需要自动提交，可以使用SqlSessionFactory.openSession(true);
     * */
    @Test
    public void testMyBatis() throws IOException {
        //加载MyBatis的核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //创建sqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        //通过核心配置文件所对应的字节输入流创建工厂类sqlSessionFactory，生产SqlSession对象
        SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(is);
        //创建sqlSession对象，此时通过SqlSession对象所操作的sql都必须手动提交或回滚事务
        SqlSession sqlSession=sqlSessionFactory.openSession();
        //创建SqlSession对象，此时通过SqlSession对象所操作的sql都会自动提交
//        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        //通过代理模式，创建UserMapper接口的代理实现类对象 获取mapper接口对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //测试功能 调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配映射文件中的SQL标签，并执行标签中的sql语句
        int result = mapper.insertUser();
        //提交事务
        sqlSession.commit();
        System.out.println("result:"+result);
    }

    @Test
    public void testCRUD() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //修改用户信息
//        int result = mapper.updateUser();
        //删除用户信息
//        int result = mapper.deleteUser();
//        System.out.println("result:"+result);
//        User user = mapper.getUserById();
//        System.out.println(user);
        List<User> list = mapper.getAllUser();
        list.forEach(user -> System.out.println(user));
    }
}
