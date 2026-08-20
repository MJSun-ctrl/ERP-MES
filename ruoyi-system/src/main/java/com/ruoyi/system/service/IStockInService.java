package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.StockIn;

/**
 * 入库记录Service接口
 * 
 * @author ruoyi
 * @date 2026-08-19
 */
public interface IStockInService 
{
    /**
     * 查询入库记录
     * 
     * @param stockId 入库记录主键
     * @return 入库记录
     */
    public StockIn selectStockInByStockId(Long stockId);

    /**
     * 查询入库记录列表
     * 
     * @param stockIn 入库记录
     * @return 入库记录集合
     */
    public List<StockIn> selectStockInList(StockIn stockIn);

    /**
     * 新增入库记录
     * 
     * @param stockIn 入库记录
     * @return 结果
     */
    public int insertStockIn(StockIn stockIn);

    /**
     * 修改入库记录
     * 
     * @param stockIn 入库记录
     * @return 结果
     */
    public int updateStockIn(StockIn stockIn);

    /**
     * 批量删除入库记录
     * 
     * @param stockIds 需要删除的入库记录主键集合
     * @return 结果
     */
    public int deleteStockInByStockIds(String stockIds);

    /**
     * 删除入库记录信息
     * 
     * @param stockId 入库记录主键
     * @return 结果
     */
    public int deleteStockInByStockId(Long stockId);
}
