package com.xlb.service.impl;

import com.xlb.entity.StationInfo;
import com.xlb.dao.StationInfoDao;
import com.xlb.service.StationInfoService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (StationInfo)表服务实现类
 *
 * @author makejava
 * @since 2024-09-10 21:51:52
 */
@Service("stationInfoService")
public class StationInfoServiceImpl implements StationInfoService {
    @Resource
    private StationInfoDao stationInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param tid 主键
     * @return 实例对象
     */
    @Override
    public StationInfo queryById(Integer tid) {
        return this.stationInfoDao.queryById(tid);
    }

    /**
     * 分页查询
     *
     * @param stationInfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<StationInfo> queryByPage(StationInfo stationInfo, PageRequest pageRequest) {
        long total = this.stationInfoDao.count(stationInfo);
        return new PageImpl<>(this.stationInfoDao.queryAllByLimit(stationInfo, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param stationInfo 实例对象
     * @return 实例对象
     */
    @Override
    public StationInfo insert(StationInfo stationInfo) {
        this.stationInfoDao.insert(stationInfo);
        return stationInfo;
    }

    /**
     * 修改数据
     *
     * @param stationInfo 实例对象
     * @return 实例对象
     */
    @Override
    public StationInfo update(StationInfo stationInfo) {
        this.stationInfoDao.update(stationInfo);
        return this.queryById(stationInfo.getTid());
    }

    /**
     * 通过主键删除数据
     *
     * @param tid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer tid) {
        return this.stationInfoDao.deleteById(tid) > 0;
    }
}
