package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SalesOrderItem;

/**
 * 销售订单明细Service接口
 * 
 * @author ruoyi
 * @date 2026-08-18
 */
public interface ISalesOrderItemService 
{
    /**
     * 查询销售订单明细
     * 
     * @param itemId 销售订单明细主键
     * @return 销售订单明细
     */
    public SalesOrderItem selectSalesOrderItemByItemId(Long itemId);

    /**
     * 查询销售订单明细列表
     * 
     * @param salesOrderItem 销售订单明细
     * @return 销售订单明细集合
     */
    public List<SalesOrderItem> selectSalesOrderItemList(SalesOrderItem salesOrderItem);

    /**
     * 新增销售订单明细
     * 
     * @param salesOrderItem 销售订单明细
     * @return 结果
     */
    public int insertSalesOrderItem(SalesOrderItem salesOrderItem);

    /**
     * 修改销售订单明细
     * 
     * @param salesOrderItem 销售订单明细
     * @return 结果
     */
    public int updateSalesOrderItem(SalesOrderItem salesOrderItem);

    /**
     * 批量删除销售订单明细
     * 
     * @param itemIds 需要删除的销售订单明细主键集合
     * @return 结果
     */
    public int deleteSalesOrderItemByItemIds(String itemIds);

    /**
     * 删除销售订单明细信息
     * 
     * @param itemId 销售订单明细主键
     * @return 结果
     */
    public int deleteSalesOrderItemByItemId(Long itemId);
}
