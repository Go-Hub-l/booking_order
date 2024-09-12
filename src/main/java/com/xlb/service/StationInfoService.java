package com.xlb.service;

import com.xlb.entity.StationInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (StationInfo)表服务接口
 *
 * @author makejava
 * @since 2024-09-10 21:52:12
 */
public interface StationInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param tid 主键
     * @return 实例对象
     */
    StationInfo queryById(Integer tid);

    /**
     * 分页查询
     *
     * @param stationInfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<StationInfo> queryByPage(StationInfo stationInfo, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param stationInfo 实例对象
     * @return 实例对象
     */
    StationInfo insert(StationInfo stationInfo);

    /**
     * 修改数据
     *
     * @param stationInfo 实例对象
     * @return 实例对象
     */
    StationInfo update(StationInfo stationInfo);

    /**
     * 通过主键删除数据
     *
     * @param tid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer tid);

}
