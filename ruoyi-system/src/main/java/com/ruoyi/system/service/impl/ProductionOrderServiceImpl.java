package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ProductionOrderMapper;
import com.ruoyi.system.domain.ProductionOrder;
import com.ruoyi.system.service.IProductionOrderService;
import com.ruoyi.common.core.text.Convert;

/**
 * 生产工单Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-08-18
 */
@Service
public class ProductionOrderServiceImpl implements IProductionOrderService 
{
    @Autowired
    private ProductionOrderMapper productionOrderMapper;

    /**
     * 查询生产工单
     * 
     * @param orderId 生产工单主键
     * @return 生产工单
     */
    @Override
    public ProductionOrder selectProductionOrderByOrderId(Long orderId)
    {
        return productionOrderMapper.selectProductionOrderByOrderId(orderId);
    }

    /**
     * 查询生产工单列表
     * 
     * @param productionOrder 生产工单
     * @return 生产工单
     */
    @Override
    public List<ProductionOrder> selectProductionOrderList(ProductionOrder productionOrder)
    {
        return productionOrderMapper.selectProductionOrderList(productionOrder);
    }

    /**
     * 新增生产工单
     * 
     * @param productionOrder 生产工单
     * @return 结果
     */
    @Override
    public int insertProductionOrder(ProductionOrder productionOrder)
    {
        productionOrder.setCreateTime(DateUtils.getNowDate());
        return productionOrderMapper.insertProductionOrder(productionOrder);
    }

    /**
     * 修改生产工单
     * 
     * @param productionOrder 生产工单
     * @return 结果
     */
    @Override
    public int updateProductionOrder(ProductionOrder productionOrder)
    {
        productionOrder.setUpdateTime(DateUtils.getNowDate());
        return productionOrderMapper.updateProductionOrder(productionOrder);
    }

    /**
     * 批量删除生产工单
     * 
     * @param orderIds 需要删除的生产工单主键
     * @return 结果
     */
    @Override
    public int deleteProductionOrderByOrderIds(String orderIds)
    {
        return productionOrderMapper.deleteProductionOrderByOrderIds(Convert.toStrArray(orderIds));
    }

    /**
     * 删除生产工单信息
     * 
     * @param orderId 生产工单主键
     * @return 结果
     */
    @Override
    public int deleteProductionOrderByOrderId(Long orderId)
    {
        return productionOrderMapper.deleteProductionOrderByOrderId(orderId);
    }
}
