DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `item`;
DROP TABLE IF EXISTS `product`;
DROP TABLE IF EXISTS `cart`;
DROP TABLE IF EXISTS `order`;
DROP TABLE IF EXISTS `consume_history`;

create table `user`
(
    `id`           int(11)      not null auto_increment,
    `uid`          varchar(255) not null,
    `username`     varchar(255) not null,
    `password`     varchar(255) not null,
    `avatar`       varchar(255) not null,
    `gender`       varchar(255) not null,
    `phone_number` varchar(255) not null UNIQUE KEY,
    `create_time`  datetime,
    primary key (`id`)
) engine = InnoDB
  default charset = utf8;

create table `item`
(
    `id`          int(11)      not null auto_increment,
    `pid`         varchar(255) not null,
    `cover`       varchar(255),
    `attributes`  text,
    `price`       double       not null,
    `stock`       int(11)      not null,
    `create_time` datetime,
    `update_time` datetime,
    primary key (`id`)
) engine = InnoDB
  default charset = utf8;

create table `product`
(
    `id`          int(11)      not null auto_increment,
    `pid`         varchar(255) not null,
    `title`       varchar(255) not null,
    `cover`       varchar(255),
    `seller`      varchar(255) not null,
    `detail_url`  varchar(255),
    `category`    varchar(255) not null,
    `price`       double       not null,
    `attributes`  text,
    `create_time` datetime,
    `update_time` datetime,
    primary key (`id`)
) engine = InnoDB
  default charset = utf8;

create table `cart`
(
    `id`      int(11)      not null auto_increment,
    `uid`     varchar(255) not null,
    `item_id` varchar(255) not null,
    `count`   int(11)      not null,
    `sum`     double       not null,
    primary key (`id`)
) engine = InnoDB
  default charset = utf8;

create table `order`
(
    `oid`          varchar(255) not null,
    `uid`          varchar(255) not null,
    `item_id`      varchar(255) not null,
    `sum`          double       not null,
    `count`        int(11)      not null,
    `recipient`    varchar(255),
    `address`      varchar(255),
    `phone_number` varchar(255),
    `create_time`  datetime,
    primary key (`oid`)
) engine = InnoDB
  default charset = utf8;

create table `consume_history`
(
    `id`           int(11)      not null auto_increment,
    `oid`          varchar(255) not null,
    `uid`          varchar(255) not null,
    `item_id`      varchar(255) not null,
    `count`        int(11)      not null,
    `sum`          double       not null,
    `recipient`    varchar(255),
    `address`      varchar(255),
    `phone_number` varchar(255),
    `create_time`  datetime,
    primary key (`id`)
) engine = InnoDB
  default charset = utf8;


CREATE TABLE `tag_bitmap`
(
    `id`     int          NOT NULL AUTO_INCREMENT,
    `tag`    varchar(255) NOT NULL COMMENT '标签',
    `count`  int          NOT NULL DEFAULT 0 COMMENT '属于该标签的商品',
    `bitmap` blob         NULL,
    PRIMARY KEY (`id`)
);

-- index==============================================================
create index `idx_uid` on `user` (`uid`);
create index `idx_pid` on `item` (`pid`);
