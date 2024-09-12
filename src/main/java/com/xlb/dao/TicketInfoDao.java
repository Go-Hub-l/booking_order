package com.xlb.dao;

import com.xlb.entity.TicketInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (TicketInfo)表数据库访问层
 *
 * @author makejava
 * @since 2024-09-10 21:45:18
 */
@Repository
public interface TicketInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param tid 主键
     * @return 实例对象
     */
    TicketInfo queryById(Integer tid);

    /**
     * 通过ID查询单条数据
     *
     * @param trainNumber 车次号
     * @return 实例对象
     */
    List<TicketInfo> queryByTrainNumber(String trainNumber);

    /**
     * 查询指定行数据
     *
     * @param ticketInfo 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<TicketInfo> queryAllByLimit(TicketInfo ticketInfo, @Param("pageable") Pageable pageable);

    /**
     * 查询指定行数据
     *
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<TicketInfo> queryAllByLimitNoCondition(@Param("pageable") Pageable pageable);

    /**
     * 查询指定行数据
     *
     * @return 对象列表
     */
    List<TicketInfo> queryAll();

    /**
     * 统计总行数
     *
     * @param ticketInfo 查询条件
     * @return 总行数
     */
    long count(TicketInfo ticketInfo);

    /**
     * 新增数据
     *
     * @param ticketInfo 实例对象
     * @return 影响行数
     */
    int insert(TicketInfo ticketInfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TicketInfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TicketInfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TicketInfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TicketInfo> entities);

    /**
     * 修改数据
     *
     * @param ticketInfo 实例对象
     * @return 影响行数
     */
    int update(TicketInfo ticketInfo);

    /**
     * 通过主键删除数据
     *
     * @param tid 主键
     * @return 影响行数
     */
    int deleteById(Integer tid);

}

