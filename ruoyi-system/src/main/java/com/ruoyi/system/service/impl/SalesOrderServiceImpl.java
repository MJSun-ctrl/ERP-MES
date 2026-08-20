package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SalesOrderMapper;
import com.ruoyi.system.domain.SalesOrder;
import com.ruoyi.system.service.ISalesOrderService;
import com.ruoyi.common.core.text.Convert;

/**
 * 销售订单Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-08-18
 */
@Service
public class SalesOrderServiceImpl implements ISalesOrderService 
{
    @Autowired
    private SalesOrderMapper salesOrderMapper;

    /**
     * 查询销售订单
     * 
     * @param orderId 销售订单主键
     * @return 销售订单
     */
    @Override
    public SalesOrder selectSalesOrderByOrderId(Long orderId)
    {
        return salesOrderMapper.selectSalesOrderByOrderId(orderId);
    }

    /**
     * 查询销售订单列表
     * 
     * @param salesOrder 销售订单
     * @return 销售订单
     */
    @Override
    public List<SalesOrder> selectSalesOrderList(SalesOrder salesOrder)
    {
        return salesOrderMapper.selectSalesOrderList(salesOrder);
    }

    /**
     * 新增销售订单
     * 
     * @param salesOrder 销售订单
     * @return 结果
     */
    @Override
    public int insertSalesOrder(SalesOrder salesOrder)
    {
        salesOrder.setCreateTime(DateUtils.getNowDate());
        return salesOrderMapper.insertSalesOrder(salesOrder);
    }

    /**
     * 修改销售订单
     * 
     * @param salesOrder 销售订单
     * @return 结果
     */
    @Override
    public int updateSalesOrder(SalesOrder salesOrder)
    {
        salesOrder.setUpdateTime(DateUtils.getNowDate());
        return salesOrderMapper.updateSalesOrder(salesOrder);
    }

    /**
     * 批量删除销售订单
     * 
     * @param orderIds 需要删除的销售订单主键
     * @return 结果
     */
    @Override
    public int deleteSalesOrderByOrderIds(String orderIds)
    {
        return salesOrderMapper.deleteSalesOrderByOrderIds(Convert.toStrArray(orderIds));
    }

    /**
     * 删除销售订单信息
     * 
     * @param orderId 销售订单主键
     * @return 结果
     */
    @Override
    public int deleteSalesOrderByOrderId(Long orderId)
    {
        return salesOrderMapper.deleteSalesOrderByOrderId(orderId);
    }
}
