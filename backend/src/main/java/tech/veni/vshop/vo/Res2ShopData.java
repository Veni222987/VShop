package tech.veni.vshop.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.veni.vshop.dao.Goods;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Res2ShopData {
    Integer id;
    Goods goods;
    Integer count;
    Double sum;
    Timestamp createTime;
}
