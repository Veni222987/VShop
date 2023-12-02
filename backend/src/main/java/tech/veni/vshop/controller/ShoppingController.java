package tech.veni.vshop.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.veni.vshop.dao.Cart;
import tech.veni.vshop.dao.WatchHistory;
import tech.veni.vshop.service.ShoppingService;
import tech.veni.vshop.vo.BaseRes;
import tech.veni.vshop.vo.Req4Settle;

import java.net.URLDecoder;

@RestController
@RequestMapping("/api/shopping")
public class ShoppingController {
    @Autowired
    private ShoppingService shoppingService;

    /**
     * 首页获取商品
     */
    @GetMapping("/home")
    public BaseRes home(@Param("page") Integer page, @Param("size") Integer size) {
        BaseRes res = new BaseRes();
        var data = shoppingService.listGoodsHome(page, size);
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
     * 获取分类商品，使用路由参数，中文采用URL编码
     * 例如：/api/shopping/category/%E7%94%B7%E8%A3%85
     */
    @GetMapping("/category/{category}")
    public BaseRes category(@PathVariable("category") String category) {
        BaseRes res = new BaseRes();
        try {
            category = URLDecoder.decode(category, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            res.setCode(500);
            res.setMsg("category解码失败");
            return res;
        }
        var data = shoppingService.listGoodsCategory(category);
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
     * 获取商品详情，使用路由参数
     */
    @GetMapping("/detail/{id}")
    public BaseRes detail(@PathVariable("id") String id) {
        BaseRes res = new BaseRes();
        var data = shoppingService.getGoodsDetail(id);
        if (data == null) {
            res.setCode(500);
            res.setMsg("获取商品详情失败");
            return res;
        }
        res.setCode(200);
        res.setData(data);
        return res;
    }

    /**
     * 加购物车
     */
    @GetMapping("/addCart")
    public BaseRes addCart(@RequestBody Cart cart) {
        BaseRes res = new BaseRes();
        shoppingService.addGoodsToCart(cart);
        res.setCode(200);
        return res;
    }

    /**
     * 获取购物车
     */
    @GetMapping("/cart/{uid}")
    public BaseRes cart(@PathVariable("uid") String uid) {
        BaseRes res = new BaseRes();
        var data = shoppingService.listCartGoods(uid);
        if (data == null) {
            res.setCode(500);
            res.setMsg("获取购物车失败");
            return res;
        }
        res.setCode(200);
        res.setData(data);
        return res;
    }

    /**
     * 结算购物车商品
     */
    @GetMapping("/settle")
    public BaseRes settle(@RequestBody Req4Settle req4Settle) {
        BaseRes res = new BaseRes();
        shoppingService.deleteCartGoods(req4Settle.getUid(), req4Settle.getGoodsIds());
        res.setCode(200);
        return res;
    }

    /**
     * 付款并发送邮件
     */
    @GetMapping("/pay")
    public BaseRes pay() {
        BaseRes res = new BaseRes();
        // TODO 付款
        return res;
    }

    /**
     * 获取客户购买记录
     */
    @GetMapping("/history")
    public BaseRes history(@Param("uid") String uid) {
        BaseRes res = new BaseRes();
        var data = shoppingService.listConsumeHistory(uid);
        if (data == null) {
            res.setCode(500);
            res.setMsg("获取购买记录失败");
            return res;
        }
        res.setCode(200);
        res.setData(data);
        return res;
    }

    /**
     * 获取客户浏览记录
     */
    @GetMapping("/browse_history")
    public BaseRes browse(@Param("uid") String uid) {
        BaseRes res = new BaseRes();
        var data = shoppingService.listGoodsHistory(uid);
        if (data == null) {
            res.setCode(500);
            res.setMsg("获取购买记录失败");
            return res;
        }
        res.setCode(200);
        res.setData(data);
        return res;
    }

    /**
     * 插入浏览记录
     */
    @GetMapping("/add_browse_history")
    public BaseRes addBrowse(@RequestBody WatchHistory watchHistory) {
        BaseRes res = new BaseRes();
        shoppingService.addGoodsHistory(watchHistory);
        return res;
    }
}