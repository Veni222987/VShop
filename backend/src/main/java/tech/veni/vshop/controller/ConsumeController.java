package tech.veni.vshop.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.veni.vshop.service.ConsumeService;

import java.util.HashMap;

@RestController
@RequestMapping("/api/consume")
public class ConsumeController {
    @Autowired
    private ConsumeService consumeService;

    @PostMapping("/add_cart")
    public HashMap<String, Object> addCart(@RequestBody HashMap<String, Object> params) {
        String uid = (String) params.get("uid");
        String itemId = (String) params.get("itemId");
        Integer count = (Integer) params.get("count");
        consumeService.addCart(uid, itemId, count);
        HashMap<String, Object> res = new HashMap<>();
        res.put("code", 200);
        res.put("msg", "success");
        return res;
    }

    @GetMapping("/list_cart")
    public HashMap<String, Object> listCart(@Param("uid") String uid) {
        HashMap<String, Object> res = new HashMap<>();
        res.put("code", 200);
        res.put("msg", "success");
        res.put("data", consumeService.listCart(uid));
        return res;
    }


    //清空某人购物车，生成订单
    @PostMapping("/settle")
    public HashMap<String, Object> settle(@Param("uid") String uid) {
        HashMap<String, Object> res = new HashMap<>();
        res.put("code", 200);
        res.put("msg", "success");
        res.put("data", consumeService.settle(uid));
        return res;
    }

    @GetMapping("/list_order")
    public HashMap<String, Object> listOrder(@Param("uid") String uid) {
        HashMap<String, Object> res = new HashMap<>();
        res.put("code", 200);
        res.put("msg", "success");
        res.put("data", consumeService.listOrder(uid));
        return res;
    }

    //结算订单
    @GetMapping("/pay")
    public HashMap<String, Object> pay(@Param("oid") String oid, @Param("uid") String uid) {
        var payMsg = consumeService.pay(uid, oid);
        HashMap<String, Object> res = new HashMap<>();
        res.put("code", 200);
        res.put("msg", "success");
        res.put("data", payMsg);
        return res;
    }

    @GetMapping("/history/list")
    public HashMap<String, Object> listConsumeHistory(@Param("uid") String uid) {
        HashMap<String, Object> res = new HashMap<>();
        res.put("code", 200);
        res.put("msg", "success");
        res.put("data", consumeService.listConsumeHistory(uid));
        return res;
    }
}
