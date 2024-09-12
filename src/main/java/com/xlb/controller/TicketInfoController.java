package com.xlb.controller;

import com.xlb.entity.TicketInfo;
import com.xlb.service.TicketInfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TicketInfo)表控制层
 *
 * @author makejava
 * @since 2024-09-10 21:52:44
 */
@RestController
@RequestMapping("ticketInfo")
public class TicketInfoController {
    /**
     * 服务对象
     */
    @Resource
    private TicketInfoService ticketInfoService;

    /**
     * 分页查询
     *
     * @param ticketInfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<TicketInfo>> queryByPage(TicketInfo ticketInfo, PageRequest pageRequest) {
        return ResponseEntity.ok(this.ticketInfoService.queryByPage(ticketInfo, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<TicketInfo> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.ticketInfoService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param ticketInfo 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<TicketInfo> add(TicketInfo ticketInfo) {
        return ResponseEntity.ok(this.ticketInfoService.insert(ticketInfo));
    }

    /**
     * 编辑数据
     *
     * @param ticketInfo 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<TicketInfo> edit(TicketInfo ticketInfo) {
        return ResponseEntity.ok(this.ticketInfoService.update(ticketInfo));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.ticketInfoService.deleteById(id));
    }

}

