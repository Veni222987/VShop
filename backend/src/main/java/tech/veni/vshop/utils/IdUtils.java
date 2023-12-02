package tech.veni.vshop.utils;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

public class IdUtils {
    private static final Snowflake UID_SNOWFLAKE = IdUtil.getSnowflake(1, 1);
    private static final Snowflake ORDERID_SNOWFLAKE = IdUtil.getSnowflake(2, 1);

    private static final Snowflake SID_SNOWFLAKE = IdUtil.getSnowflake(3, 1);

    private static final Snowflake GOODSID_SNOWFLAKE = IdUtil.getSnowflake(4, 1);

    public static Long generateUid() {
        return UID_SNOWFLAKE.nextId();
    }

    public static Long generateOrderId() {
        return ORDERID_SNOWFLAKE.nextId();
    }

    public static Long generateSid() {
        return SID_SNOWFLAKE.nextId();
    }

    public static Long generateGoodsId() {
        return GOODSID_SNOWFLAKE.nextId();
    }
}
