package tech.veni.vshop.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.veni.vshop.dao.Shop;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Res2Goods {
    Integer id;
    String goodsId;
    String title;
    String coverUrl;
    String detailUrl;
    Shop shop;
    String category;
    Double price;
    Integer stock;
    Timestamp createTime;
}
