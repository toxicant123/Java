package com.toxicant123.mybatisplus.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.toxicant123.mybatisplus.mapper.ProductMapper;
import com.toxicant123.mybatisplus.pojo.Product;
import com.toxicant123.mybatisplus.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2022-03-20 11:19
 */
@Service
@DS("slave_1")
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
}
