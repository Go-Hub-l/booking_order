package com.xlb.service.impl;

import com.xlb.entity.TicketInfo;
import com.xlb.dao.TicketInfoDao;
import com.xlb.service.TicketInfoService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (TicketInfo)表服务实现类
 *
 * @author makejava
 * @since 2024-09-10 21:52:44
 */
@Service("ticketInfoService")
public class TicketInfoServiceImpl implements TicketInfoService {
    @Resource
    private TicketInfoDao ticketInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param tid 主键
     * @return 实例对象
     */
    @Override
    public TicketInfo queryById(Integer tid) {
        return this.ticketInfoDao.queryById(tid);
    }

    /**
     * 分页查询
     *
     * @param ticketInfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<TicketInfo> queryByPage(TicketInfo ticketInfo, PageRequest pageRequest) {
        long total = this.ticketInfoDao.count(ticketInfo);
        return new PageImpl<>(this.ticketInfoDao.queryAllByLimit(ticketInfo, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param ticketInfo 实例对象
     * @return 实例对象
     */
    @Override
    public TicketInfo insert(TicketInfo ticketInfo) {
        this.ticketInfoDao.insert(ticketInfo);
        return ticketInfo;
    }

    /**
     * 修改数据
     *
     * @param ticketInfo 实例对象
     * @return 实例对象
     */
    @Override
    public TicketInfo update(TicketInfo ticketInfo) {
        this.ticketInfoDao.update(ticketInfo);
        return this.queryById(ticketInfo.getTid());
    }

    /**
     * 通过主键删除数据
     *
     * @param tid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer tid) {
        return this.ticketInfoDao.deleteById(tid) > 0;
    }
}
