package com.xlb.service;

import com.xlb.entity.TicketInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (TicketInfo)表服务接口
 *
 * @author makejava
 * @since 2024-09-10 21:52:44
 */
public interface TicketInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param tid 主键
     * @return 实例对象
     */
    TicketInfo queryById(Integer tid);

    /**
     * 分页查询
     *
     * @param ticketInfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<TicketInfo> queryByPage(TicketInfo ticketInfo, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param ticketInfo 实例对象
     * @return 实例对象
     */
    TicketInfo insert(TicketInfo ticketInfo);

    /**
     * 修改数据
     *
     * @param ticketInfo 实例对象
     * @return 实例对象
     */
    TicketInfo update(TicketInfo ticketInfo);

    /**
     * 通过主键删除数据
     *
     * @param tid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer tid);

}
