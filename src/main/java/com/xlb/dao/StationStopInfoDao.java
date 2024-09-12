package com.xlb.dao;

import com.xlb.entity.StationStopInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (StationStopInfo)表数据库访问层
 *
 * @author makejava
 * @since 2024-09-11 10:50:01
 */
@Repository
public interface StationStopInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param tid 主键
     * @return 实例对象
     */
    StationStopInfo queryById(Integer tid);

    /**
     * 通过ID查询单条数据
     *
     * @param trainNumber 车次号
     * @return 实例对象
     */
    List<StationStopInfo> queryByTrainNumber(String trainNumber);

    /**
     * 查询指定行数据
     *
     * @param stationStopInfo 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<StationStopInfo> queryAllByLimit(StationStopInfo stationStopInfo, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param stationStopInfo 查询条件
     * @return 总行数
     */
    long count(StationStopInfo stationStopInfo);

    /**
     * 新增数据
     *
     * @param stationStopInfo 实例对象
     * @return 影响行数
     */
    int insert(StationStopInfo stationStopInfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<StationStopInfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<StationStopInfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<StationStopInfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<StationStopInfo> entities);

    /**
     * 修改数据
     *
     * @param stationStopInfo 实例对象
     * @return 影响行数
     */
    int update(StationStopInfo stationStopInfo);

    /**
     * 通过主键删除数据
     *
     * @param tid 主键
     * @return 影响行数
     */
    int deleteById(Integer tid);

}

