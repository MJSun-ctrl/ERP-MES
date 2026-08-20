package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.ProductionPlan;

/**
 * 生产计划Mapper接口
 * 
 * @author Mingjian Sun
 * @date 2026-08-18
 */
public interface ProductionPlanMapper 
{
    /**
     * 查询生产计划
     * 
     * @param planId 生产计划主键
     * @return 生产计划
     */
    public ProductionPlan selectProductionPlanByPlanId(Long planId);

    /**
     * 查询生产计划列表
     * 
     * @param productionPlan 生产计划
     * @return 生产计划集合
     */
    public List<ProductionPlan> selectProductionPlanList(ProductionPlan productionPlan);

    /**
     * 新增生产计划
     * 
     * @param productionPlan 生产计划
     * @return 结果
     */
    public int insertProductionPlan(ProductionPlan productionPlan);

    /**
     * 修改生产计划
     * 
     * @param productionPlan 生产计划
     * @return 结果
     */
    public int updateProductionPlan(ProductionPlan productionPlan);

    /**
     * 删除生产计划
     * 
     * @param planId 生产计划主键
     * @return 结果
     */
    public int deleteProductionPlanByPlanId(Long planId);

    /**
     * 批量删除生产计划
     * 
     * @param planIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteProductionPlanByPlanIds(String[] planIds);
}
