package com.kaishengit.service;

import com.kaishengit.entity.Tag;
import com.kaishengit.entity.User;
import com.kaishengit.mapper.UserMapper;
import com.kaishengit.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by Administrator on 2017/10/24.
 */
public class UserMapperTestCase {

    private static SqlSession sqlSession;
    private static UserMapper userMapper;

    @Before
    public void init() {
        sqlSession = MyBatisUtil.openSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @After
    public void close() {
        sqlSession.close();
    }

   @Test
    public void findUserByIdTest() {

       User user = userMapper.findUserById(1);
       System.out.println(user);
       System.out.println(user.getUserName() + "-->"+ user.getDept().getDeptName());
    }

    @Test
    public void findByIdWithTagTest() {
        User user = userMapper.findByIdWithTag(2);
        System.out.println(user);

        List<Tag> tagList = user.getTagList();
        for(Tag tag : tagList) {
            System.out.println(tag);
        }
    }
}
