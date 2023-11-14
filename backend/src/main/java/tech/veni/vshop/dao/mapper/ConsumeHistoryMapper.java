package tech.veni.vshop.dao.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tech.veni.vshop.dao.ConsumeHistory;

@Mapper
public interface ConsumeHistoryMapper {

    @Insert("INSERT INTO `consume_history` (`id`, `uid`, `item_id`, `count`, `sum`, `create_time`)"
            + " VALUES (#{consumeHistory.id}, #{consumeHistory.uid}, #{consumeHistory.itemId}, #{consumeHistory.count}, #{consumeHistory.sum}, #{consumeHistory.createTime})")
    void insert(@Param("consumeHistory") ConsumeHistory consumeHistory);
}
