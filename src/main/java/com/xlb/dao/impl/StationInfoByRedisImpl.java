package com.xlb.dao.impl;

import com.xlb.conststr.CacheKey;
import com.xlb.dao.StationInfoByRedisDao;
import com.xlb.entity.StationInfo;
import com.xlb.util.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;


@Slf4j
@Repository
public class StationInfoByRedisImpl implements StationInfoByRedisDao {
    @Autowired
    private RedisService redisService;

    @Override
    public StationInfo queryById(Integer tid) {
        String cacheKey = CacheKey.stationInfoQueryByIdCacheKey(tid);

        if (redisService.exists(cacheKey)) {
            log.info("get stationInfo from redis cache, cacheKey: {}", cacheKey);
            return (StationInfo) redisService.get(cacheKey);
        }
        return null;
    }

    @Override
    public List<StationInfo> queryAllByLimit(StationInfo stationInfo, Pageable pageable) {
        return null;
    }

    @Override
    public long count(StationInfo stationInfo) {
        return 0;
    }

    @Override
    public int insert(StationInfo stationInfo) {
        return 0;
    }

    @Override
    public int insertBatch(List<StationInfo> entities) {
        return 0;
    }

    @Override
    public int insertOrUpdateBatch(List<StationInfo> entities) {
        return 0;
    }

    @Override
    public int update(StationInfo stationInfo) {
        return 0;
    }

    @Override
    public int deleteById(Integer tid) {
        return 0;
    }

    @Override
    public StationInfo queryByStationName(String stationName) {
        return null;
    }
}
