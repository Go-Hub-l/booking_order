package com.xlb.controller;

import com.xlb.entity.StationStopInfo;
import com.xlb.service.StationStopInfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (StationStopInfo)表控制层
 *
 * @author makejava
 * @since 2024-09-10 21:52:34
 */
@RestController
@RequestMapping("stationStopInfo")
public class StationStopInfoController {
    /**
     * 服务对象
     */
    @Resource
    private StationStopInfoService stationStopInfoService;

    /**
     * 分页查询
     *
     * @param stationStopInfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<StationStopInfo>> queryByPage(StationStopInfo stationStopInfo, PageRequest pageRequest) {
        return ResponseEntity.ok(this.stationStopInfoService.queryByPage(stationStopInfo, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<StationStopInfo> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.stationStopInfoService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param stationStopInfo 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<StationStopInfo> add(StationStopInfo stationStopInfo) {
        return ResponseEntity.ok(this.stationStopInfoService.insert(stationStopInfo));
    }

    /**
     * 编辑数据
     *
     * @param stationStopInfo 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<StationStopInfo> edit(StationStopInfo stationStopInfo) {
        return ResponseEntity.ok(this.stationStopInfoService.update(stationStopInfo));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.stationStopInfoService.deleteById(id));
    }

}

