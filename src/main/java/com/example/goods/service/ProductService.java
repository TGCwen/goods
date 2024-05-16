package com.example.goods.service;

import com.example.goods.pojo.PageBean;
import com.example.goods.pojo.Product;

import java.util.List;

public interface ProductService {
    List<Product> list();

    String getName(Integer id);

    Product getById(Integer id);

    void delete(Integer id);

    void add(Product product);

    PageBean page(Integer page, Integer pageSize);

    public void update(Product product);
}
