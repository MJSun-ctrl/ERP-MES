package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ProductionPlanMapper;
import com.ruoyi.system.domain.ProductionPlan;
import com.ruoyi.system.service.IProductionPlanService;
import com.ruoyi.common.core.text.Convert;

/**
 * 生产计划Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-08-18
 */
@Service
public class ProductionPlanServiceImpl implements IProductionPlanService 
{
    @Autowired
    private ProductionPlanMapper productionPlanMapper;

    /**
     * 查询生产计划
     * 
     * @param planId 生产计划主键
     * @return 生产计划
     */
    @Override
    public ProductionPlan selectProductionPlanByPlanId(Long planId)
    {
        return productionPlanMapper.selectProductionPlanByPlanId(planId);
    }

    /**
     * 查询生产计划列表
     * 
     * @param productionPlan 生产计划
     * @return 生产计划
     */
    @Override
    public List<ProductionPlan> selectProductionPlanList(ProductionPlan productionPlan)
    {
        return productionPlanMapper.selectProductionPlanList(productionPlan);
    }

    /**
     * 新增生产计划
     * 
     * @param productionPlan 生产计划
     * @return 结果
     */
    @Override
    public int insertProductionPlan(ProductionPlan productionPlan)
    {
        productionPlan.setCreateTime(DateUtils.getNowDate());
        return productionPlanMapper.insertProductionPlan(productionPlan);
    }

    /**
     * 修改生产计划
     * 
     * @param productionPlan 生产计划
     * @return 结果
     */
    @Override
    public int updateProductionPlan(ProductionPlan productionPlan)
    {
        productionPlan.setUpdateTime(DateUtils.getNowDate());
        return productionPlanMapper.updateProductionPlan(productionPlan);
    }

    /**
     * 批量删除生产计划
     * 
     * @param planIds 需要删除的生产计划主键
     * @return 结果
     */
    @Override
    public int deleteProductionPlanByPlanIds(String planIds)
    {
        return productionPlanMapper.deleteProductionPlanByPlanIds(Convert.toStrArray(planIds));
    }

    /**
     * 删除生产计划信息
     * 
     * @param planId 生产计划主键
     * @return 结果
     */
    @Override
    public int deleteProductionPlanByPlanId(Long planId)
    {
        return productionPlanMapper.deleteProductionPlanByPlanId(planId);
    }
}
