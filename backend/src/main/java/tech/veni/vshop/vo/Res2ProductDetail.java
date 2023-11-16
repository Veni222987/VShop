package tech.veni.vshop.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.veni.vshop.dao.Item;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Res2ProductDetail {
    // Product的属性
    private String pid;
    private String title;
    private String cover;
    private String seller;
    private String detailUrl;
    private String category;
    private Double price;
    private String attributes;
    List<Item> items;
}
