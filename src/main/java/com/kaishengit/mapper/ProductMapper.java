package com.kaishengit.mapper;

import com.kaishengit.entity.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/10/24.
 */
public interface ProductMapper {
    int batchSave(@Param("productList") List<Product> productList);
}
