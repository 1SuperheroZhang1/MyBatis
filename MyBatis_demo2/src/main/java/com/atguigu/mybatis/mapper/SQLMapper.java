package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SQLMapper {
    /**
     * 测试模糊查询
     * 根据用户名模糊查询用户信息
     * @param username
     * @return
     * */
    List<User> getUserByLike(@Param(value = "username") String username);

    /**
     * 批量删除
     * @param ids
     * @return
     * */
    int deleteMore(@Param(value = "ids") String ids);

    /**
     * 动态设置表名，查询所有的用户信息
     * 查询指定表中的数据
     * @param tableName
     * @return
     * */
    List<User> getUserByTableName(@Param(value = "tableName") String tableName);

    /**
     * 添加用户信息
     * @param user
     * @return
     *
     * useGeneratedKeys:设置使用自增的主键
     * keyProperty：因为增删改有统一的返回值是受影响的行数，因此只能将获取的自增的主键放到传输的参数user对象的某个属性值中
     * */
    int insertUser(User user);
}
