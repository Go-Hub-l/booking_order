package com.xlb.dao;

import com.xlb.entity.StationInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (StationInfo)表数据库访问层
 *
 * @author makejava
 * @since 2024-09-10 21:48:47
 */
@Repository
public interface StationInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param tid 主键
     * @return 实例对象
     */
    StationInfo queryById(Integer tid);

    /**
     * 查询指定行数据
     *
     * @param stationInfo 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<StationInfo> queryAllByLimit(StationInfo stationInfo, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param stationInfo 查询条件
     * @return 总行数
     */
    long count(StationInfo stationInfo);

    /**
     * 新增数据
     *
     * @param stationInfo 实例对象
     * @return 影响行数
     */
    int insert(StationInfo stationInfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<StationInfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<StationInfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<StationInfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<StationInfo> entities);

    /**
     * 修改数据
     *
     * @param stationInfo 实例对象
     * @return 影响行数
     */
    int update(StationInfo stationInfo);

    /**
     * 通过主键删除数据
     *
     * @param tid 主键
     * @return 影响行数
     */
    int deleteById(Integer tid);

    /**
     * 根据车站名查询车站信息
     * @param stationName
     * @return
     */
    StationInfo queryByStationName(String stationName);
}

