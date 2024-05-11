package com.example.goods;

import com.example.goods.mapper.ProductMapper;
import com.example.goods.pojo.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class GoodsApplicationTests {

    @Autowired
    private ProductMapper productMapper;

    // 遍历
    @Test
    public void testProduct() {
        List<Product> productList = productMapper.list();
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    // 删除
    @Test
    public void testDelete() {
        productMapper.delete(3);
    }

    // 新增，测试返回主键
    @Test
    public void testInsert() {
        //创建员工对象
        Product product = new Product();
        product.setName("-------");
        product.setPrice(123);
        product.setImage("1.jpg");
        product.setStock(1123);
        product.setType((short) 1);
        //调用添加方法
        productMapper.insert(product);

        System.out.println(product.getId());
    }
}
