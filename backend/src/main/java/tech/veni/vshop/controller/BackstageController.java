package tech.veni.vshop.controller;

import org.springframework.web.bind.annotation.*;
import tech.veni.vshop.vo.BaseRes;

@RestController
@RequestMapping("/api/backstage")
public class BackstageController {

    /**
     * 新增商品
     */
    @PostMapping("/goods/add")
    public BaseRes addGoods() {
        BaseRes res = new BaseRes();
        // TODO 新增商品
        return res;
    }

    /**
     * 修改商品
     */
    @PostMapping("/goods/update")
    public BaseRes updateGoods() {
        BaseRes res = new BaseRes();
        // TODO 修改商品
        return res;
    }

    /**
     * 删除商品
     */
    @DeleteMapping("/goods/delete")
    public BaseRes deleteGoods() {
        BaseRes res = new BaseRes();
        // TODO 删除商品
        return res;
    }

    @GetMapping("/goods/list")
    public BaseRes listGoods() {
        BaseRes res = new BaseRes();
        // TODO 商品列表
        return res;
    }

    /**
     * 查看商铺销售数据
     */
    @GetMapping("/shop/sales")
    public BaseRes shopSales() {
        BaseRes res = new BaseRes();
        // TODO 查看商铺销售数据
        return res;
    }

    /**
     * 查看商品销售数据
     */
    @GetMapping("/goods/sales")
    public BaseRes goodsSales() {
        BaseRes res = new BaseRes();
        // TODO 查看商品销售数据
        return res;
    }
}
