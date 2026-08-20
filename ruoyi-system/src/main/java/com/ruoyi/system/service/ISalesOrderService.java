package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SalesOrder;

/**
 * 销售订单Service接口
 * 
 * @author ruoyi
 * @date 2026-08-18
 */
public interface ISalesOrderService 
{
    /**
     * 查询销售订单
     * 
     * @param orderId 销售订单主键
     * @return 销售订单
     */
    public SalesOrder selectSalesOrderByOrderId(Long orderId);

    /**
     * 查询销售订单列表
     * 
     * @param salesOrder 销售订单
     * @return 销售订单集合
     */
    public List<SalesOrder> selectSalesOrderList(SalesOrder salesOrder);

    /**
     * 新增销售订单
     * 
     * @param salesOrder 销售订单
     * @return 结果
     */
    public int insertSalesOrder(SalesOrder salesOrder);

    /**
     * 修改销售订单
     * 
     * @param salesOrder 销售订单
     * @return 结果
     */
    public int updateSalesOrder(SalesOrder salesOrder);

    /**
     * 批量删除销售订单
     * 
     * @param orderIds 需要删除的销售订单主键集合
     * @return 结果
     */
    public int deleteSalesOrderByOrderIds(String orderIds);

    /**
     * 删除销售订单信息
     * 
     * @param orderId 销售订单主键
     * @return 结果
     */
    public int deleteSalesOrderByOrderId(Long orderId);
}
