package com.kaishengit.mapper;

import com.kaishengit.entity.Tag;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by hoyt on 2017/10/26.
 */
public interface TagMapper {

    @Select("select * from t_tag where id in (select tid from t_user_tag where uid = #{userId})")
    List<Tag> findByUserId(int id);
}
