package tech.veni.vshop.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.veni.vshop.dao.Goods;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Res2BrowseHistory {
    Integer id;
    String uid;
    Goods goods;
    Timestamp createTime;
}
