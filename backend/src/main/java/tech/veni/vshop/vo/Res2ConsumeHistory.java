package tech.veni.vshop.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.veni.vshop.dao.Goods;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Res2ConsumeHistory {
    Integer id;
    String orderId;
    String uid;
    Goods goods;
    Integer count;
    Double sum;
    Integer addressId;
    Timestamp createTime;
}
