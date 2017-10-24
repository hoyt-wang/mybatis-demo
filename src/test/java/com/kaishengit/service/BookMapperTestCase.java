package com.kaishengit.service;

import com.kaishengit.entity.Book;
import com.kaishengit.mapper.BookMapper;
import com.kaishengit.util.MyBatisUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/24.
 */
public class BookMapperTestCase {

    private SqlSession sqlSession;
    private BookMapper bookMapper;

    @Before
    public void init() {
        sqlSession = MyBatisUtil.openSession();
        bookMapper = sqlSession.getMapper(BookMapper.class);
    }

    @After
    public void close() {
        sqlSession.close();
    }

    @Test
    public void  findBookByKeysTest() {
        String keys = "%技术%";
        List<Book> bookList =bookMapper.findBookByKeys(keys);
        if(bookList != null && bookList.size() > 0) {
            for (Book book : bookList) {
                System.out.println(book);
            }
        }
    }

    @Test
    public void findBookByParamTest() {
        Map<String,Object> param = new HashMap<>();
        param.put("keys","%java%");
        param.put("author","张玉红");
        List<Book> bookList =bookMapper.findBookByParam(param);
        if(bookList != null && bookList.size() > 0) {
            for (Book book : bookList) {
                System.out.println(book);
            }
        }
    }

    @Test
    public void findByIdListTest() {
        List<Integer> idList = Arrays.asList(6,8,12);
        List<Book> bookList =bookMapper.findByIdList(idList);
        if(bookList != null && bookList.size() > 0) {
            for (Book book : bookList) {
                System.out.println(book);
            }
        }
    }
}
