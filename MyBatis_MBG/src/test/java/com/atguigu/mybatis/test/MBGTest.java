package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.pojo.EmpExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MBGTest {

    /**
     * QBC风格的增删改查：
     *  QBC风格：Query By Criteria - mybatis逆向工程之奢华尊享版
     * */
    @Test
    public void testMBG(){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            //查询所有数据
//            List<Emp> list = mapper.selectByExample(null);
//            list.forEach(emp -> System.out.println(emp));
            //根据条件查询
            //创建条件对象，通过andXXX方法为SQL添加查询添加，每个条件之间是and关系
//            EmpExample example=new EmpExample();
//            example.createCriteria().andEmpNameEqualTo("张三").andAgeGreaterThan(20);
            //将之前添加的条件通过or拼接其他条件
//            example.or().andDidIsNotNull();
//            List<Emp> list = mapper.selectByExample(example);
//            list.forEach(emp -> System.out.println(emp));
            //修改功能
            //updateByPrimaryKey：如果修改的某字段为null，则将该字段修改为null
//            mapper.updateByPrimaryKey(new Emp(1,"admin",23,"女","456@qq.com",3));
            //updateByPrimaryKeySelective：如果修改的某字段为null,则将不会修改该字段的值
            mapper.updateByPrimaryKeySelective(new Emp(1,"admin",23,null,"456@qq.com",3));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
