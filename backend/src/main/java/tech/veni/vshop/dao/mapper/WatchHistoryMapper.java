package tech.veni.vshop.dao.mapper;

import org.apache.ibatis.annotations.*;
import tech.veni.vshop.dao.WatchHistory;
import tech.veni.vshop.vo.Res2BrowseHistory;

import java.util.List;

@Mapper
public interface WatchHistoryMapper {

    /**
     * 插入浏览历史
     *
     * @param watchHistory
     */
    @Insert("INSERT INTO `watch_history` (`id`, `uid`, `goods_id`, `create_time`)"
            + " VALUES (#{watchHistory.id}, #{watchHistory.uid}, #{watchHistory.goodsId}, #{watchHistory.createTime})")
    void insert(@Param("watchHistory") WatchHistory watchHistory);

    /**
     * 根据uid查询浏览历史
     *
     * @param uid
     */
    @Select("SELECT * FROM `watch_history` WHERE `uid` = #{uid}")
    List<WatchHistory> selectByUid(@Param("uid") String uid);

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "goods", column = "goods_id", one = @One(select = "tech.veni.vshop.dao.mapper.GoodsMapper.selectOneByGoodsId")),
            @Result(property = "createTime", column = "create_time")
    })
    @Select("SELECT * FROM `watch_history` WHERE `uid` = #{uid}")
    List<Res2BrowseHistory> selectByUid4Detail(@Param("uid") String uid);
}
