package tech.veni.vshop.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.veni.vshop.dao.Cart;
import tech.veni.vshop.dao.ConsumeHistory;
import tech.veni.vshop.dao.WatchHistory;
import tech.veni.vshop.dao.mapper.CartMapper;
import tech.veni.vshop.dao.mapper.ConsumeHistoryMapper;
import tech.veni.vshop.dao.mapper.GoodsMapper;
import tech.veni.vshop.dao.mapper.WatchHistoryMapper;
import tech.veni.vshop.service.ShoppingService;
import tech.veni.vshop.vo.Res2Goods;

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

    @Override
    public List<Res2Goods> listGoodsHome(Integer page, Integer size) {
        return goodsMapper.selectByPage((page - 1) * size, size);
    }

    @Override
    public List<Res2Goods> listGoodsCategory(String category) {
        return goodsMapper.selectByCategory(category);
    }

    @Override
    public Res2Goods getGoodsDetail(String id) {
        return goodsMapper.selectByGoodsId(id);
    }

    @Override
    public void addGoodsToCart(Cart cart) {
        cartMapper.insert(cart);
    }

    @Override
    public List<Cart> listCartGoods(String uid) {
        return cartMapper.selectByUid(uid);
    }

    @Override
    public void deleteCartGoods(String uid, List<String> goodsIds) {
        cartMapper.deleteCartGoods(uid, goodsIds);
    }

    @Override
    public List<ConsumeHistory> listConsumeHistory(String uid) {
        return consumeHistoryMapper.listByUid(uid);
    }

    @Override
    public void addGoodsHistory(WatchHistory watchHistory) {
        watchHistoryMapper.insert(watchHistory);
    }

    @Override
    public List<WatchHistory> listGoodsHistory(String uid) {
        return watchHistoryMapper.selectByUid(uid);
    }


}
