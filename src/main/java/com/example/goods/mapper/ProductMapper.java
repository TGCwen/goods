package com.example.goods.mapper;

import com.example.goods.pojo.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {

    @Select("select id, name, price, image, stock, type from product")
    public List<Product> list();

    @Select("select name from product where id = #{id}")
    public String getName(Integer id);

    @Select("select id, name, price, image, stock, type from product where id = #{id}")
    public Product getById(Integer id);

    @Select("select id, name, price, image, stock, type from product")
    public List<Product> page(Integer start, Integer pageSize);

    @Delete("delete from product where id = #{id}")
    public void delete(Integer id);

    //会自动将生成的主键值，赋值给product对象的id属性
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into product(name,price,image,stock,type) values (#{name}, #{price}, #{image}, #{stock}, #{type})")
    public void insert(Product product);

    public void update(Product product);

}
