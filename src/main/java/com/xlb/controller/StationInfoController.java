package com.xlb.controller;

import com.xlb.entity.StationInfo;
import com.xlb.service.StationInfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (StationInfo)表控制层
 *
 * @author makejava
 * @since 2024-09-10 21:51:24
 */
@RestController
@RequestMapping("stationInfo")
public class StationInfoController {
    /**
     * 服务对象
     */
    @Resource
    private StationInfoService stationInfoService;

    /**
     * 分页查询
     *
     * @param stationInfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<StationInfo>> queryByPage(StationInfo stationInfo, PageRequest pageRequest) {
        return ResponseEntity.ok(this.stationInfoService.queryByPage(stationInfo, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<StationInfo> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.stationInfoService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param stationInfo 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<StationInfo> add(StationInfo stationInfo) {
        return ResponseEntity.ok(this.stationInfoService.insert(stationInfo));
    }

    /**
     * 编辑数据
     *
     * @param stationInfo 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<StationInfo> edit(StationInfo stationInfo) {
        return ResponseEntity.ok(this.stationInfoService.update(stationInfo));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.stationInfoService.deleteById(id));
    }

}

