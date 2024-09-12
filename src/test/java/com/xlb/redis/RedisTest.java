package com.xlb.redis;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.xlb.conststr.CacheKey;
import com.xlb.entity.StationInfo;
import com.xlb.util.RedisService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class RedisTest {
    @Autowired
    private RedisService redisService;

    @Test
    public void testRedis() {
        setRedis();
        StationInfo stationInfo = getRedis();
        Assert.isTrue(stationInfo != null, "获取缓存失败");
        Assert.isTrue(stationInfo.getTid() == 1, "获取数据错误");
        Assert.isTrue(stationInfo.getStationName().equals("测试站点"), "获取数据错误");

        deleteRedis();
        StationInfo stationInfo2 = getRedis();
        Assert.isNull(stationInfo2, "删除缓存失败");
    }
    void setRedis() {
        String cacheKey = CacheKey.stationInfoQueryByIdCacheKey(1);
        StationInfo stationInfo = new StationInfo();
        stationInfo.setTid(1);
        stationInfo.setStationName("测试站点");
        stationInfo.setStationCode("TS");
        stationInfo.setStationSpell("TEST");
//        String json = JSONUtil.toJsonStr(stationInfo);

//        redisService.set(cacheKey, json);
        redisService.set(cacheKey, stationInfo);
    }

    StationInfo getRedis() {
        String cacheKey = CacheKey.stationInfoQueryByIdCacheKey(1);
        Object o = redisService.get(cacheKey);
//        JSONObject jsonObject = JSONUtil.parseObj(redisService.get(cacheKey));
//        StationInfo stationInfo = jsonObject.toBean(StationInfo.class);
//        return stationInfo;
        return (StationInfo) redisService.get(cacheKey) ;
    }
    void deleteRedis() {
        String cacheKey = CacheKey.stationInfoQueryByIdCacheKey(1);
        redisService.delete(cacheKey);
    }
}
