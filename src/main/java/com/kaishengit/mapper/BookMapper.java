package com.kaishengit.mapper;

import com.kaishengit.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/24.
 */
public interface BookMapper {
   List<Book> findBookByKeys(@Param("keys") String keys);
   List<Book> findBookByParam(Map<String,Object> param);
   List<Book> findByIdList(@Param("idList") List<Integer> idList);
}
