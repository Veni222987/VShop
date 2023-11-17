package tech.veni.vshop.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import tech.veni.vshop.dao.Cart;
import tech.veni.vshop.dao.ConsumeHistory;
import tech.veni.vshop.dao.Item;
import tech.veni.vshop.dao.Order;
import tech.veni.vshop.dao.mapper.CartMapper;
import tech.veni.vshop.dao.mapper.ConsumeHistoryMapper;
import tech.veni.vshop.dao.mapper.ItemMapper;
import tech.veni.vshop.dao.mapper.OrderMapper;
import tech.veni.vshop.service.ConsumeService;
import tech.veni.vshop.utils.TimeUtils;
import tech.veni.vshop.vo.Res2Cart;
import tech.veni.vshop.vo.Res2Order;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service
public class ConsumeServiceImpl implements ConsumeService {
    @Autowired
    ItemMapper itemMapper;

    @Autowired
    CartMapper cartMapper;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    ConsumeHistoryMapper consumeHistoryMapper;

    @Override
    public void addCart(String uid, String itemId, Integer count) {
        Cart cart = new Cart(
                null,
                uid,
                itemId,
                1,
                0
        );
        cartMapper.insert(cart);
    }

    @Override
    public Res2Cart listCart(String uid) {
        Res2Cart res = new Res2Cart(
                uid,
                0D,
                new ArrayList<>()
        );
        List<Cart> carts = cartMapper.selectByUid(uid);
        for (Cart cart : carts) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("count", cart.getCount());
            map.put("item", itemMapper.selectById(cart.getItemId()));
            res.getItems().add(map);
            res.setSum(res.getSum() + cart.getSum());
        }
        return res;
    }

    @Override
    public Res2Order settle(String uid) {
        Res2Order res = new Res2Order(
                uid,
                uid + System.currentTimeMillis(),
                new ArrayList<>(),
                0D,
                null,
                null,
                null,
                TimeUtils.getDateTimeNow()
        );
        //获取某人的购物车
        List<Cart> carts = cartMapper.selectByUid(uid);
        for (Cart cart : carts) {
            String itemId = cart.getItemId();
            Integer count = cart.getCount();
            //获取某人的购物车中的某个商品
            Item item = itemMapper.selectById(itemId);
            Res2Order.ShortItem shortItem = itemMapper.selectShortItemById(itemId);
            shortItem.setCount(count);
            res.getItems().add(shortItem);
            res.setSum(res.getSum() + item.getPrice() * count);
            //加入Order
            Order order = new Order(
                    null,
                    uid + System.currentTimeMillis(),
                    itemId,
                    item.getPrice() * count,
                    count,
                    null,
                    null,
                    null,
                    new Timestamp(System.currentTimeMillis())
            );
            orderMapper.insert(order);
        }
        //从购物车中删除某个人的所有商品
        cartMapper.deleteByUid(uid);
        return res;
    }

    @Override
    public String pay(String uid, String oid) {
        List<Order> orders = orderMapper.selectByOid(oid);
        if (ObjectUtils.isEmpty(orders))
            return "订单不存在";
        for (var order : orders) {
            consumeHistoryMapper.insertByOrders(order);
        }
        //删除orders
        orderMapper.deleteByOid(oid);
        return "支付成功";
    }

    @Override
    public List<ConsumeHistory> listConsumeHistory(String uid) {
        return consumeHistoryMapper.list(uid);
    }


}
