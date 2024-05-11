-- 创建商品表
DROP TABLE IF EXISTS `product`;
create table product
(
    id    int primary key auto_increment,
    name  varchar(255)   not null,
    price decimal(10, 2) not null,
    image varchar(255),
    stock int            not null comment '库存',
    type  tinyint unsigned comment '分类, 1:宝可梦, 2:鬼灭主角团, 3:鬼灭的柱'
) comment '产品表';

-- 添加商品系列1
insert into product(id, name, price, image, stock, type)
VALUES (null, '杰尼龟', 89, '/img/杰尼龟.jpg', 10, 1),
       (null, '皮卡丘', 89, '/img/皮卡丘.jpg', 10, 1),
       (null, '可达鸭', 89, '/img/可达鸭.jpg', 10, 1),
       (null, '妙蛙种子', 89, '/img/妙蛙种子.jpg', 10, 1);
-- 添加商品系列2
insert into product(id, name, price, image, stock, type)
VALUES (null, '头柱', 89, '/img/头柱.jpg', 10, 2),
       (null, '祢豆子', 89, '/img/祢豆子.jpg', 10, 2),
       (null, '一只猪', 89, '/img/一只猪.jpg', 10, 2),
       (null, '善逸', 89, '/img/善逸.jpg', 10, 2);
-- 添加商品系列3
insert into product(id, name, price, image, stock, type)
VALUES (null, '虫柱', 79, '/img/虫柱.jpg', 10, 2),
       (null, '风柱', 79, '/img/风柱.jpg', 10, 2),
       (null, '蛇柱', 79, '/img/蛇柱.jpg', 10, 2),
       (null, '水柱', 79, '/img/水柱.jpg', 10, 2),
       (null, '炎柱', 79, '/img/炎柱.jpg', 10, 2),
       (null, '霞柱', 79, '/img/霞柱.jpg', 10, 2),
       (null, '岩柱', 79, '/img/岩柱.jpg', 10, 2),
       (null, '恋柱', 79, '/img/恋柱.jpg', 10, 2),
       (null, '音柱', 79, '/img/音柱.jpg', 10, 2);