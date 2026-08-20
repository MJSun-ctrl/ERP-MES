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
import com.ruoyi.system.domain.ProductionOrder;
import com.ruoyi.system.service.IProductionOrderService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

import com.ruoyi.system.domain.MesTask;
import com.ruoyi.system.service.IMesTaskService;

/**
 * 生产工单Controller
 * 
 * @author Mingjian Sun
 * @date 2026-08-18
 */
@Controller
@RequestMapping("/manufacture/order")
public class ProductionOrderController extends BaseController
{
    private String prefix = "manufacture/order";

    @Autowired
    private IProductionOrderService productionOrderService;

@Autowired
private IMesTaskService mesTaskService;

    @RequiresPermissions("manufacture:order:view")
    @GetMapping()
    public String order()
    {
        return prefix + "/order";
    }

    /**
     * 查询生产工单列表
     */
    @RequiresPermissions("manufacture:order:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProductionOrder productionOrder)
    {
        startPage();
        List<ProductionOrder> list = productionOrderService.selectProductionOrderList(productionOrder);
        return getDataTable(list);
    }

    /**
     * 导出生产工单列表
     */
    @RequiresPermissions("manufacture:order:export")
    @Log(title = "生产工单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProductionOrder productionOrder)
    {
        List<ProductionOrder> list = productionOrderService.selectProductionOrderList(productionOrder);
        ExcelUtil<ProductionOrder> util = new ExcelUtil<ProductionOrder>(ProductionOrder.class);
        return util.exportExcel(list, "生产工单数据");
    }

    /**
     * 新增生产工单
     */
    @RequiresPermissions("manufacture:order:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存生产工单
     */
    @RequiresPermissions("manufacture:order:add")
    @Log(title = "生产工单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProductionOrder productionOrder)
    {
        return toAjax(productionOrderService.insertProductionOrder(productionOrder));
    }

    /**
     * 修改生产工单
     */
    @RequiresPermissions("manufacture:order:edit")
    @GetMapping("/edit/{orderId}")
    public String edit(@PathVariable("orderId") Long orderId, ModelMap mmap)
    {
        ProductionOrder productionOrder = productionOrderService.selectProductionOrderByOrderId(orderId);
        mmap.put("productionOrder", productionOrder);
        return prefix + "/edit";
    }

    /**
     * 修改保存生产工单
     */
    @RequiresPermissions("manufacture:order:edit")
    @Log(title = "生产工单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProductionOrder productionOrder)
    {
        return toAjax(productionOrderService.updateProductionOrder(productionOrder));
    }

    /**
     * 删除生产工单
     */
    @RequiresPermissions("manufacture:order:remove")
    @Log(title = "生产工单", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(productionOrderService.deleteProductionOrderByOrderIds(ids));
    }

/**
 * 下达MES
 */
/**
 * 下达MES
 */
@RequiresPermissions("manufacture:order:edit")
@Log(title = "下达MES", businessType = BusinessType.UPDATE)
@PostMapping("/sendMES/{orderId}")
@ResponseBody
public AjaxResult sendMES(@PathVariable("orderId") Long orderId)
{
    System.out.println("==========进入sendMES方法==========");
    ProductionOrder productionOrder =
            productionOrderService.selectProductionOrderByOrderId(orderId);


    if(productionOrder == null)
    {
        return AjaxResult.error("工单不存在");
    }


    // 防止重复下达
    if("1".equals(productionOrder.getStatus()))
    {
        return AjaxResult.error("该工单已经下达MES");
    }


    /*
     * 1. 创建MES任务
     */

    MesTask mesTask = new MesTask();


    // MES任务编号
    mesTask.setTaskCode(
            "TASK" + System.currentTimeMillis()
    );


    // 来源工单
    mesTask.setOrderId(
            productionOrder.getOrderId()
    );


    // 产品
    mesTask.setProductId(
            productionOrder.getProductId()
    );


    // 数量
    mesTask.setQuantity(
            productionOrder.getQuantity()
    );


    // 状态
    //0 待执行
    mesTask.setStatus("0");


    mesTaskService.insertMesTask(mesTask);



    /*
     * 2. 更新工单状态
     */

    productionOrder.setStatus("1");


    productionOrderService.updateProductionOrder(
            productionOrder
    );


    return AjaxResult.success("工单已下达MES");
}
}
