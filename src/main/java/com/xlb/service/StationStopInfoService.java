package com.xlb.service;

import com.xlb.entity.StationStopInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (StationStopInfo)表服务接口
 *
 * @author makejava
 * @since 2024-09-10 21:52:34
 */
public interface StationStopInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param tid 主键
     * @return 实例对象
     */
    StationStopInfo queryById(Integer tid);

    /**
     * 分页查询
     *
     * @param stationStopInfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<StationStopInfo> queryByPage(StationStopInfo stationStopInfo, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param stationStopInfo 实例对象
     * @return 实例对象
     */
    StationStopInfo insert(StationStopInfo stationStopInfo);

    /**
     * 修改数据
     *
     * @param stationStopInfo 实例对象
     * @return 实例对象
     */
    StationStopInfo update(StationStopInfo stationStopInfo);

    /**
     * 通过主键删除数据
     *
     * @param tid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer tid);

}
