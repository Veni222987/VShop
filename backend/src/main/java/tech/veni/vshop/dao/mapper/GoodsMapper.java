package tech.veni.vshop.dao.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tech.veni.vshop.dao.Goods;

@Mapper
public interface GoodsMapper {

    /**
     * 插入单件商品
     *
     * @param goods
     */
    @Insert("INSERT INTO `goods` (`id`, `goods_id`,`title`,`cover_url`,`detail_url`,`shop_id`,`category`,`price`,`stock`,`create_time`,`update_time`)"
            + " VALUES (#{goods.id}, #{goods.goodsId}, #{goods.title}, #{goods.coverUrl}, #{goods.detailUrl}, #{goods.shopId}, #{goods.category}, #{goods.price}, #{goods.stock}, #{goods.createTime}, #{goods.updateTime})")
    void insert(@Param("goods") Goods goods);
}
