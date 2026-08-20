package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.StockInMapper;
import com.ruoyi.system.domain.StockIn;
import com.ruoyi.system.service.IStockInService;
import com.ruoyi.common.core.text.Convert;

/**
 * 入库记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-08-19
 */
@Service
public class StockInServiceImpl implements IStockInService 
{
    @Autowired
    private StockInMapper stockInMapper;

    /**
     * 查询入库记录
     * 
     * @param stockId 入库记录主键
     * @return 入库记录
     */
    @Override
    public StockIn selectStockInByStockId(Long stockId)
    {
        return stockInMapper.selectStockInByStockId(stockId);
    }

    /**
     * 查询入库记录列表
     * 
     * @param stockIn 入库记录
     * @return 入库记录
     */
    @Override
    public List<StockIn> selectStockInList(StockIn stockIn)
    {
        return stockInMapper.selectStockInList(stockIn);
    }

    /**
     * 新增入库记录
     * 
     * @param stockIn 入库记录
     * @return 结果
     */
    @Override
    public int insertStockIn(StockIn stockIn)
    {
        stockIn.setCreateTime(DateUtils.getNowDate());
        return stockInMapper.insertStockIn(stockIn);
    }

    /**
     * 修改入库记录
     * 
     * @param stockIn 入库记录
     * @return 结果
     */
    @Override
    public int updateStockIn(StockIn stockIn)
    {
        return stockInMapper.updateStockIn(stockIn);
    }

    /**
     * 批量删除入库记录
     * 
     * @param stockIds 需要删除的入库记录主键
     * @return 结果
     */
    @Override
    public int deleteStockInByStockIds(String stockIds)
    {
        return stockInMapper.deleteStockInByStockIds(Convert.toStrArray(stockIds));
    }

    /**
     * 删除入库记录信息
     * 
     * @param stockId 入库记录主键
     * @return 结果
     */
    @Override
    public int deleteStockInByStockId(Long stockId)
    {
        return stockInMapper.deleteStockInByStockId(stockId);
    }
}
