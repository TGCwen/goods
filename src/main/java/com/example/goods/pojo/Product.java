package com.example.goods.pojo;

import lombok.Data;

@Data
public class Product {
    private Integer id; //id
    private String name; //姓名
    private Integer price; //价格
    private String image; //图片
    private Integer stock; //库存
    private Short type; //种类
}
