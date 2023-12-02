package tech.veni.vshop.dao.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tech.veni.vshop.dao.WatchHistory;

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
}
