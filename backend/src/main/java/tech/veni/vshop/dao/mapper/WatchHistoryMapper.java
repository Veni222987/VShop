package tech.veni.vshop.dao.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tech.veni.vshop.dao.WatchHistory;

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
}
