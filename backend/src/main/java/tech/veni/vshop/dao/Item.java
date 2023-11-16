package tech.veni.vshop.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    Long id;
    String pid;
    String cover;
    String attributes;
    Double price;
    Integer stock;
    Timestamp createTime;
    Timestamp updateTime;
}
