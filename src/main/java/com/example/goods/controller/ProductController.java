package com.example.goods.controller;

import com.example.goods.pojo.PageBean;
import com.example.goods.pojo.Product;
import com.example.goods.pojo.Result;
import com.example.goods.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public Result list() {
        log.info("查询所有产品信息");
        List<Product> productList = productService.list();
        return Result.success(productList);
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("根据id查询产品信息");
        List<Product> product = productService.getById(id);
        return Result.success(product);
    }

    @GetMapping("/page")
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize) {
        //记录日志
        log.info("分页查询，参数：{},{}", page, pageSize);
        //调用业务层分页查询功能
        PageBean pageBean = productService.page(page, pageSize);
        //响应
        return Result.success(pageBean);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("根据id删除产品");
        productService.delete(id);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Product product) {
        log.info("新增产品:{}", product);
        productService.add(product);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody Product product) {
        productService.update(product);
        return Result.success();
    }
}
