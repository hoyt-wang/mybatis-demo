package com.kaishengit.mapper;

import com.kaishengit.entity.Dept;
import org.apache.ibatis.annotations.Select;

/**
 * Created by hoyt on 2017/10/26.
 */
public interface DeptMapper {

    @Select("select * from t_dept where id = #{id}")
    Dept findById(int id);
}
