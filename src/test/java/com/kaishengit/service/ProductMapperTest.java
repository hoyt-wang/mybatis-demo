package com.kaishengit.service;

import com.kaishengit.entity.Product;
import com.kaishengit.mapper.ProductMapper;
import com.kaishengit.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/10/24.
 */
public class ProductMapperTest {
    private static SqlSession sqlSession;
    private static ProductMapper productMapper;

    @Before
    public void init() {
        sqlSession = MyBatisUtil.openSession();
        productMapper = sqlSession.getMapper(ProductMapper.class);
    }

    @After
    public void close() {
        sqlSession.close();
    }

    @Test
    public void batchSave() {
        Product product1 = new Product("AA",100);
        Product product2 = new Product("BB",100);
        Product product3 = new Product("CC",100);

        List<Product> productList = Arrays.asList(product1,product2,product3);
        productMapper.batchSave(productList);

        sqlSession.commit();
    }
}
