package tech.veni.vshop.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.veni.vshop.dao.Goods;
import tech.veni.vshop.service.BackstageService;
import tech.veni.vshop.vo.BaseRes;

@RestController
@RequestMapping("/api/backstage")
public class BackstageController {
    @Autowired
    BackstageService backstageService;

    /**
     * 新增商品
     */
    @PostMapping("/goods/add")
    public BaseRes addGoods(@RequestBody Goods goods) {
        BaseRes res = new BaseRes();
        backstageService.addGoods(goods);
        res.setCode(200);
        return res;
    }

    /**
     * 修改商品
     */
    @PostMapping("/goods/update")
    public BaseRes updateGoods(@RequestBody Goods goods) {
        BaseRes res = new BaseRes();
        backstageService.updateGoods(goods);
        res.setCode(200);
        return res;
    }

    /**
     * 删除商品
     */
    @DeleteMapping("/goods/delete")
    public BaseRes deleteGoods(@Param("goodsId") String goodsId) {
        BaseRes res = new BaseRes();
        backstageService.deleteGoods("goodsId");
        return res;
    }

    @GetMapping("/goods/list/{sid}")
    public BaseRes listGoods(@PathVariable("sid") String sid) {
        BaseRes res = new BaseRes();
        var data = backstageService.listGoods(sid);
        if (data == null) {
            res.setCode(500);
            res.setMsg("获取商品失败");
            return res;
        }
        res.setCode(200);
        res.setData(data);
        return res;
    }

    /**
     * 查看商铺销售数据
     */
    @GetMapping("/shop/sales")
    public BaseRes shopSales(@Param("sid") String sid) {
        BaseRes res = new BaseRes();
        var data = backstageService.listOrder(sid);
        if (data == null) {
            res.setCode(500);
            res.setMsg("获取商铺销售数据失败");
            return res;
        }
        res.setCode(200);
        res.setData(data);
        return res;
    }

    /**
     * 查看商品销售数据
     */
    @GetMapping("/goods/sales")
    public BaseRes goodsSales() {
        BaseRes res = new BaseRes();
        var data = backstageService.listGoodsOrder("goodsId");
        if (data == null) {
            res.setCode(500);
            res.setMsg("获取商品销售数据失败");
            return res;
        }
        res.setCode(200);
        res.setData(data);
        return res;
    }
}
