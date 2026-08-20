package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SalesOrderItem;

/**
 * 销售订单明细Mapper接口
 * 
 * @author Mingjian Sun
 * @date 2026-08-18
 */
public interface SalesOrderItemMapper 
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
     * 删除销售订单明细
     * 
     * @param itemId 销售订单明细主键
     * @return 结果
     */
    public int deleteSalesOrderItemByItemId(Long itemId);

    /**
     * 批量删除销售订单明细
     * 
     * @param itemIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSalesOrderItemByItemIds(String[] itemIds);
}
