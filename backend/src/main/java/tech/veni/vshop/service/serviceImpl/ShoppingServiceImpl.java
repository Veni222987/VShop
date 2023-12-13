package tech.veni.vshop.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import tech.veni.vshop.dao.*;
import tech.veni.vshop.dao.mapper.*;
import tech.veni.vshop.service.ShoppingService;
import tech.veni.vshop.utils.IdUtils;
import tech.veni.vshop.vo.Res2BrowseHistory;
import tech.veni.vshop.vo.Res2Cart;
import tech.veni.vshop.vo.Res2Goods;
import tech.veni.vshop.vo.Res2ShopData;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingServiceImpl implements ShoppingService {

    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    CartMapper cartMapper;

    @Autowired
    WatchHistoryMapper watchHistoryMapper;

    @Autowired
    ConsumeHistoryMapper consumeHistoryMapper;

    @Autowired
    JavaMailSender mailSender;

    @Autowired
    UserMapper userMapper;

    @Autowired
    AddressMapper addressMapper;

    @Override
    public List<Res2Goods> listGoodsHome(Integer page, Integer size) {
        return goodsMapper.selectByPage((page - 1) * size, size);
    }

    @Override
    public List<Res2Goods> listGoodsCategory(String category) {
        return goodsMapper.selectByCategory(category);
    }

    @Override
    public Goods getGoodsDetail(String id) {
        return goodsMapper.selectOneByGoodsId(id);
    }

    @Override
    public void addGoodsToCart(Cart cart) {
        cartMapper.insert(cart);
    }

    @Override
    public List<Res2Cart> listCartGoods(String uid) {
        return cartMapper.listByUid(uid);
    }

    @Override
    public List<ConsumeHistory> settleAndCreateOrder(String uid, List<Cart> cartList, Integer addressId) {
        //删除购物车商品
        cartMapper.deleteCartGoods(uid, cartList.stream().map(Cart::getGoodsId).toList());
        //创建订单号和ConsumeHistory返回前端，当前端付款后插入ConsumeHistory
        List<ConsumeHistory> consumeHistories = new ArrayList<>();
        for (Cart cart : cartList) {
            ConsumeHistory consumeHistory = new ConsumeHistory();
            consumeHistory.setOrderId(IdUtils.generateOrderId().toString());
            consumeHistory.setUid(uid);
            consumeHistory.setGoodsId(cart.getGoodsId());
            consumeHistory.setCount(cart.getCount());
            consumeHistory.setSum(cart.getSum());
            consumeHistory.setAddressId(addressId);
            consumeHistory.setCreateTime(new Timestamp(System.currentTimeMillis()));
            consumeHistories.add(consumeHistory);
        }
        return consumeHistories;
    }

    @Override
    public void payAndSendEmail(List<ConsumeHistory> consumeHistoryList) {
        //发送邮件
        // 查找用户信息
        var user = userMapper.selectByUid(consumeHistoryList.get(0).getUid());
        sendEmail(user.getEmail(), user.getUsername(), consumeHistoryList.get(0).getOrderId());
        //插入消费记录
        for (ConsumeHistory consumeHistory : consumeHistoryList) {
            consumeHistoryMapper.insert(consumeHistory);
        }
    }

    @Override
    public List<Res2ShopData> listConsumeHistory(String uid) {
        return consumeHistoryMapper.listByUid4Order(uid);
    }

    @Override
    public void addGoodsHistory(WatchHistory watchHistory) {
        watchHistory.setCreateTime(new Timestamp(System.currentTimeMillis()));
        watchHistoryMapper.insert(watchHistory);
    }

    @Override
    public List<Res2BrowseHistory> listGoodsHistory(String uid) {
        return watchHistoryMapper.selectByUid4Detail(uid);
    }

    @Override
    public void addAddress(Address address) {
        addressMapper.insertAddress(address);
    }

    @Override
    public List<Address> listAddress(String uid) {
        return addressMapper.selectAddressByUid(uid);
    }

    public void sendEmail(String email, String name, String orderId) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("csveni@163.com");
        message.setTo(email);
        message.setSubject("VShop购物订单" + orderId + "支付成功");
        message.setText("<h3>尊敬的" + name + "，您的订单" + orderId + "已支付成功</h3>");
        mailSender.send(message);
    }
}
