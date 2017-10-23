package com.kaishengit.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2017/10/22.
 */
public class MyBatisSqlSessionFactory {

    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSessionFactory getSqlSessionFactory() {
        Logger logger = LoggerFactory.getLogger(MyBatisSqlSessionFactory.class);
        if(sqlSessionFactory == null) {
            InputStream inputStream;
           try {
               inputStream = Resources.getResourceAsStream("mybatis-config.xml");
               sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
           } catch (IOException e) {
               throw new RuntimeException(e.getCause());
           }
        }

        return sqlSessionFactory;
    }

    public static SqlSession openSession () {

        return getSqlSessionFactory().openSession();
    }

}
