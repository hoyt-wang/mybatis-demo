package com.kaishengit.mapper;

import com.kaishengit.entity.User;
import org.apache.ibatis.annotations.*;

/**
 * Created by Administrator on 2017/10/24.
 */
public interface UserMapper {
    @Select("select * from t_user where id = #{id}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "password", column = "password"),
            @Result(property = "address", column = "address"),
            @Result(property = "dept",column = "dept_id",one = @One(
                    select = "com.kaishengit.mapper.DeptMapper.findById")),
            @Result(property = "tagList",column = "id", many = @Many
                    (select = "com.kaishengit.mapper.TagMapper.findByUserId"))
    })
    User findUserById(int id);

    User findByIdWithTag(int id);
}
