package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.ProductionOrder;

/**
 * 生产工单Mapper接口
 * 
 * @author Mingjian Sun
 * @date 2026-08-18
 */
public interface ProductionOrderMapper 
{
    /**
     * 查询生产工单
     * 
     * @param orderId 生产工单主键
     * @return 生产工单
     */
    public ProductionOrder selectProductionOrderByOrderId(Long orderId);

    /**
     * 查询生产工单列表
     * 
     * @param productionOrder 生产工单
     * @return 生产工单集合
     */
    public List<ProductionOrder> selectProductionOrderList(ProductionOrder productionOrder);

    /**
     * 新增生产工单
     * 
     * @param productionOrder 生产工单
     * @return 结果
     */
    public int insertProductionOrder(ProductionOrder productionOrder);

    /**
     * 修改生产工单
     * 
     * @param productionOrder 生产工单
     * @return 结果
     */
    public int updateProductionOrder(ProductionOrder productionOrder);

    /**
     * 删除生产工单
     * 
     * @param orderId 生产工单主键
     * @return 结果
     */
    public int deleteProductionOrderByOrderId(Long orderId);

    /**
     * 批量删除生产工单
     * 
     * @param orderIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteProductionOrderByOrderIds(String[] orderIds);
}
