package com.example.goods.service.impl;

import com.example.goods.mapper.ProductMapper;
import com.example.goods.pojo.PageBean;
import com.example.goods.pojo.Product;
import com.example.goods.service.ProductService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> list() {
        return productMapper.list();
    }

    @Override
    @Cacheable(value = "name", key = "#id")
    public String getName(Integer id) {
        String name = productMapper.getName(id);
        System.out.println("数据库获取信息！");
        return name;
    }

    @Override
    @Cacheable(value = "product", key = "#id")
    public Product getById(Integer id) {
        Product product = productMapper.getById(id);
        System.out.println("数据库获取信息！");
        return product;
    }

    @Override
    @CacheEvict(value = "product", key = "#id")
    public void delete(Integer id) {
        productMapper.delete(id);
    }

    @Override
    public void add(Product product) {
        productMapper.insert(product);
    }

    @Override
    public PageBean page(Integer page, Integer pageSize) {
        // 设置分页参数
        PageHelper.startPage(page, pageSize);
        // 执行分页查询
        List<Product> productList = productMapper.list();
        // 获取分页结果
        Page<Product> p = (Page<Product>) productList;
        //封装PageBean
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }

    @Override
    @CacheEvict(value = "product", key = "#product.id")
    public void update(Product product) {
        productMapper.update(product);
    }


}
