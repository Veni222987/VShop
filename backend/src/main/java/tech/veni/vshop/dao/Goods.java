package tech.veni.vshop.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
    Integer id;
    String goodsId;
    String title;
    String coverUrl;
    String detailUrl;
    String shopId;
    String category;
    Double price;
    Integer stock;
    Timestamp createTime;
    Timestamp updateTime;
}
