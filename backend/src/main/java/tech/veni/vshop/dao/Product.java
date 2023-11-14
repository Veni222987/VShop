package tech.veni.vshop.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    Long id;
    String pid;
    String title;
    String cover;
    String seller;
    String detailUrl;
    String attributes;
    Timestamp createTime;
    Timestamp updateTime;
}
