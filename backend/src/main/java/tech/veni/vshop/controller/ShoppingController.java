package tech.veni.vshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.veni.vshop.service.ConsumeService;
import tech.veni.vshop.vo.BaseRes;

import java.net.URLDecoder;

@RestController
@RequestMapping("/api/shopping")
public class ShoppingController {
    @Autowired
    private ConsumeService consumeService;

    /**
     * 首页获取商品
     */
    @GetMapping("/home")
    public BaseRes home() {
        BaseRes res = new BaseRes();
        // TODO 首页获取商品
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
        // TODO 获取分类商品
        return res;
    }

    /**
     * 获取商品详情，使用路由参数
     */
    @GetMapping("/detail/{id}")
    public BaseRes detail(@PathVariable("id") Integer id) {
        BaseRes res = new BaseRes();
        // TODO 获取商品详情
        return res;
    }

    /**
     * 加购物车
     */
    @GetMapping("/addCart/{id}")
    public BaseRes addCart(@PathVariable("id") Integer id) {
        BaseRes res = new BaseRes();
        // TODO 加购物车
        return res;
    }

    /**
     * 获取购物车
     */
    @GetMapping("/cart")
    public BaseRes cart() {
        BaseRes res = new BaseRes();
        // TODO 获取购物车
        return res;
    }

    /**
     * 结算购物车商品
     */
    @GetMapping("/settle")
    public BaseRes settle() {
        BaseRes res = new BaseRes();
        // TODO 结算购物车商品
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
    public BaseRes history() {
        BaseRes res = new BaseRes();
        // TODO 获取客户购买记录
        return res;
    }

    /**
     * 获取客户浏览记录
     */
    @GetMapping("/browse_history")
    public BaseRes browse() {
        BaseRes res = new BaseRes();
        // TODO 获取客户浏览记录
        return res;
    }
}
