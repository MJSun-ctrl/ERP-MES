package com.ruoyi.web.controller.manufacture;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.ProductionPlan;
import com.ruoyi.system.service.IProductionPlanService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

import com.ruoyi.system.domain.Product;
import com.ruoyi.system.service.IProductService;

import com.ruoyi.system.domain.ProductionOrder;
import com.ruoyi.system.service.IProductionOrderService;
import java.time.LocalDateTime;
/**
 * 生产计划Controller
 * 
 * @author Mingjian Sun
 * @date 2026-08-18
 */
@Controller
@RequestMapping("/manufacture/productionPlan")
public class ProductionPlanController extends BaseController
{
    private String prefix = "manufacture/productionPlan";

    @Autowired
    private IProductionPlanService productionPlanService;

    @Autowired
private IProductService productService;

@Autowired
private IProductionOrderService productionOrderService;

    @RequiresPermissions("manufacture:productionPlan:view")
    @GetMapping()
    public String productionPlan()
    {
        return prefix + "/productionPlan";
    }

    /**
     * 查询生产计划列表
     */
    @RequiresPermissions("manufacture:productionPlan:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProductionPlan productionPlan)
    {
        startPage();
        List<ProductionPlan> list = productionPlanService.selectProductionPlanList(productionPlan);
        return getDataTable(list);
    }

    /**
     * 导出生产计划列表
     */
    @RequiresPermissions("manufacture:productionPlan:export")
    @Log(title = "生产计划", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProductionPlan productionPlan)
    {
        List<ProductionPlan> list = productionPlanService.selectProductionPlanList(productionPlan);
        ExcelUtil<ProductionPlan> util = new ExcelUtil<ProductionPlan>(ProductionPlan.class);
        return util.exportExcel(list, "生产计划数据");
    }

    /**
     * 新增生产计划
     */
    @RequiresPermissions("manufacture:productionPlan:add")
    @GetMapping("/add")
public String add(ModelMap mmap)
{
    List<Product> products =
            productService.selectProductList(new Product());

    mmap.put("products", products);

    return prefix + "/add";
}

    /**
     * 新增保存生产计划
     */
    @RequiresPermissions("manufacture:productionPlan:add")
    @Log(title = "生产计划", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProductionPlan productionPlan)
    {
        return toAjax(productionPlanService.insertProductionPlan(productionPlan));
    }

    /**
     * 修改生产计划
     */
    @RequiresPermissions("manufacture:productionPlan:edit")
    @GetMapping("/edit/{planId}")
    public String edit(@PathVariable("planId") Long planId, ModelMap mmap)
    {
        ProductionPlan productionPlan = productionPlanService.selectProductionPlanByPlanId(planId);
        
        List<Product> products =
        productService.selectProductList(new Product());

mmap.put("products", products);
        
        mmap.put("productionPlan", productionPlan);
        return prefix + "/edit";
    }

    /**
     * 修改保存生产计划
     */
    @RequiresPermissions("manufacture:productionPlan:edit")
    @Log(title = "生产计划", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProductionPlan productionPlan)
    {
        return toAjax(productionPlanService.updateProductionPlan(productionPlan));
    }

    /**
     * 删除生产计划
     */
    @RequiresPermissions("manufacture:productionPlan:remove")
    @Log(title = "生产计划", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(productionPlanService.deleteProductionPlanByPlanIds(ids));
    }

    /**
 * 根据生产计划生成生产工单
 */
@RequiresPermissions("manufacture:productionPlan:add")
@Log(title = "生成生产工单", businessType = BusinessType.INSERT)
@PostMapping("/createOrder/{planId}")
@ResponseBody
public AjaxResult createOrder(@PathVariable("planId") Long planId)
{

    ProductionPlan plan =
        productionPlanService.selectProductionPlanByPlanId(planId);


    ProductionOrder order = new ProductionOrder();


    //工单编号
    order.setOrderCode(
        "WO" + System.currentTimeMillis()
    );


    //关联生产计划
    order.setPlanId(plan.getPlanId());


    //产品
    order.setProductId(plan.getProductId());


    //数量
    order.setQuantity(plan.getQuantity());


    //状态
    //0 待下达MES
    order.setStatus("0");


    productionOrderService.insertProductionOrder(order);

    plan.setStatus("1");

productionPlanService.updateProductionPlan(plan);

    return AjaxResult.success("生成工单成功");
}
}
