package tech.veni.vshop.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Res2Order {

    String uid;
    String oid;
    List<ShortItem> items;
    Double sum;
    String recipient;
    String address;
    String phoneNumber;
    String createTime;
}
