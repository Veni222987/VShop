package tech.veni.vshop.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.veni.vshop.dao.Goods;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Req4CreateProduct {
    // Product的属性
    private String title;
    private String cover;
    private String seller;
    private String detailUrl;
    private String category;
    private Double price;
    private String attributes;
    List<Goods> items;
}
