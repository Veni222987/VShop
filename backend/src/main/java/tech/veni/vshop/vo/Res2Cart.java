package tech.veni.vshop.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.veni.vshop.dao.Goods;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Res2Cart {
    Integer id;
    String uid;
    Goods goods;
    Integer count;
    Double sum;
}
