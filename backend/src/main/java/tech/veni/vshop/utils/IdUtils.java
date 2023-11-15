package tech.veni.vshop.utils;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

public class IdUtils {
    private static final Snowflake UID_SNOWFLAKE = IdUtil.getSnowflake(1, 1);
    private static final Snowflake PID_SNOWFLAKE = IdUtil.getSnowflake(2, 1);

    public static Long generateUid() {
        return UID_SNOWFLAKE.nextId();
    }

    public static Long generatePid() {
        return PID_SNOWFLAKE.nextId();
    }
}
