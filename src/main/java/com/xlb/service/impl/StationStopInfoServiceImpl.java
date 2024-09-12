package com.xlb.service.impl;

import com.xlb.entity.StationStopInfo;
import com.xlb.dao.StationStopInfoDao;
import com.xlb.service.StationStopInfoService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (StationStopInfo)表服务实现类
 *
 * @author makejava
 * @since 2024-09-10 21:52:34
 */
@Service("stationStopInfoService")
public class StationStopInfoServiceImpl implements StationStopInfoService {
    @Resource
    private StationStopInfoDao stationStopInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param tid 主键
     * @return 实例对象
     */
    @Override
    public StationStopInfo queryById(Integer tid) {
        return this.stationStopInfoDao.queryById(tid);
    }

    /**
     * 分页查询
     *
     * @param stationStopInfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<StationStopInfo> queryByPage(StationStopInfo stationStopInfo, PageRequest pageRequest) {
        long total = this.stationStopInfoDao.count(stationStopInfo);
        return new PageImpl<>(this.stationStopInfoDao.queryAllByLimit(stationStopInfo, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param stationStopInfo 实例对象
     * @return 实例对象
     */
    @Override
    public StationStopInfo insert(StationStopInfo stationStopInfo) {
        this.stationStopInfoDao.insert(stationStopInfo);
        return stationStopInfo;
    }

    /**
     * 修改数据
     *
     * @param stationStopInfo 实例对象
     * @return 实例对象
     */
    @Override
    public StationStopInfo update(StationStopInfo stationStopInfo) {
        this.stationStopInfoDao.update(stationStopInfo);
        return this.queryById(stationStopInfo.getTid());
    }

    /**
     * 通过主键删除数据
     *
     * @param tid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer tid) {
        return this.stationStopInfoDao.deleteById(tid) > 0;
    }
}
