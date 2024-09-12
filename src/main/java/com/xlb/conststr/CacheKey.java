package com.xlb.conststr;

public class CacheKey {
    public static String stationInfoQueryByIdCacheKey(Integer tid) {
        return String.format("stationInfoQueryById_%s", tid);
    }
}
