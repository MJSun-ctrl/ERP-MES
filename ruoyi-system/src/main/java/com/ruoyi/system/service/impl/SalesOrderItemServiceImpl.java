package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SalesOrderItemMapper;
import com.ruoyi.system.domain.SalesOrderItem;
import com.ruoyi.system.service.ISalesOrderItemService;
import com.ruoyi.common.core.text.Convert;

/**
 * 销售订单明细Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-08-18
 */
@Service
public class SalesOrderItemServiceImpl implements ISalesOrderItemService 
{
    @Autowired
    private SalesOrderItemMapper salesOrderItemMapper;

    /**
     * 查询销售订单明细
     * 
     * @param itemId 销售订单明细主键
     * @return 销售订单明细
     */
    @Override
    public SalesOrderItem selectSalesOrderItemByItemId(Long itemId)
    {
        return salesOrderItemMapper.selectSalesOrderItemByItemId(itemId);
    }

    /**
     * 查询销售订单明细列表
     * 
     * @param salesOrderItem 销售订单明细
     * @return 销售订单明细
     */
    @Override
    public List<SalesOrderItem> selectSalesOrderItemList(SalesOrderItem salesOrderItem)
    {
        return salesOrderItemMapper.selectSalesOrderItemList(salesOrderItem);
    }

    /**
     * 新增销售订单明细
     * 
     * @param salesOrderItem 销售订单明细
     * @return 结果
     */
    @Override
    public int insertSalesOrderItem(SalesOrderItem salesOrderItem)
    {
        salesOrderItem.setCreateTime(DateUtils.getNowDate());
        return salesOrderItemMapper.insertSalesOrderItem(salesOrderItem);
    }

    /**
     * 修改销售订单明细
     * 
     * @param salesOrderItem 销售订单明细
     * @return 结果
     */
    @Override
    public int updateSalesOrderItem(SalesOrderItem salesOrderItem)
    {
        salesOrderItem.setUpdateTime(DateUtils.getNowDate());
        return salesOrderItemMapper.updateSalesOrderItem(salesOrderItem);
    }

    /**
     * 批量删除销售订单明细
     * 
     * @param itemIds 需要删除的销售订单明细主键
     * @return 结果
     */
    @Override
    public int deleteSalesOrderItemByItemIds(String itemIds)
    {
        return salesOrderItemMapper.deleteSalesOrderItemByItemIds(Convert.toStrArray(itemIds));
    }

    /**
     * 删除销售订单明细信息
     * 
     * @param itemId 销售订单明细主键
     * @return 结果
     */
    @Override
    public int deleteSalesOrderItemByItemId(Long itemId)
    {
        return salesOrderItemMapper.deleteSalesOrderItemByItemId(itemId);
    }
}
