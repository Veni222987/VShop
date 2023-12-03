package tech.veni.vshop.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.veni.vshop.dao.ConsumeHistory;
import tech.veni.vshop.dao.Goods;
import tech.veni.vshop.dao.mapper.ConsumeHistoryMapper;
import tech.veni.vshop.dao.mapper.GoodsMapper;
import tech.veni.vshop.service.BackstageService;
import tech.veni.vshop.utils.IdUtils;

import java.sql.Timestamp;
import java.util.List;

@Service
public class BackstageServiceImpl implements BackstageService {
    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    ConsumeHistoryMapper consumeHistoryMapper;

    @Override
    public void addGoods(Goods goods) {
        goods.setGoodsId(IdUtils.generateGoodsId().toString());
        goods.setCreateTime(new Timestamp(System.currentTimeMillis()));
        goods.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        goodsMapper.insert(goods);
    }

    @Override
    public List<Goods> listGoods(String sid) {
        return goodsMapper.selectBySid(sid);
    }

    @Override
    public void updateGoods(Goods goods) {
        goodsMapper.update(goods);
    }

    @Override
    public void deleteGoods(String goodsId) {
        goodsMapper.delete(goodsId);
    }

    @Override
    public List<ConsumeHistory> listOrder(String sid) {
        return consumeHistoryMapper.listBySid(sid);
    }

    @Override
    public List<ConsumeHistory> listGoodsOrder(String goodsId) {
        return consumeHistoryMapper.listByGoodsId(goodsId);
    }
}
