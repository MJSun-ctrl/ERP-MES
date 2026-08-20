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
import com.ruoyi.system.domain.MesTask;
import com.ruoyi.system.service.IMesTaskService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

import com.ruoyi.system.domain.Inventory;
import com.ruoyi.system.domain.StockIn;

import com.ruoyi.system.service.IInventoryService;
import com.ruoyi.system.service.IStockInService;

import java.math.BigDecimal;

/**
 * MES生产任务Controller
 * 
 * @author Mingjian Sun
 * @date 2026-08-19
 */
@Controller
@RequestMapping("/manufacture/MesTask")
public class MesTaskController extends BaseController
{
    private String prefix = "manufacture/MesTask";

    @Autowired
    private IMesTaskService mesTaskService;

    @Autowired
private IInventoryService inventoryService;


@Autowired
private IStockInService stockInService;

    @RequiresPermissions("manufacture:MesTask:view")
    @GetMapping()
    public String MesTask()
    {
        return prefix + "/MesTask";
    }

    /**
     * 查询MES生产任务列表
     */
    @RequiresPermissions("manufacture:MesTask:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MesTask mesTask)
    {
        startPage();
        List<MesTask> list = mesTaskService.selectMesTaskList(mesTask);
        return getDataTable(list);
    }

    /**
     * 导出MES生产任务列表
     */
    @RequiresPermissions("manufacture:MesTask:export")
    @Log(title = "MES生产任务", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MesTask mesTask)
    {
        List<MesTask> list = mesTaskService.selectMesTaskList(mesTask);
        ExcelUtil<MesTask> util = new ExcelUtil<MesTask>(MesTask.class);
        return util.exportExcel(list, "MES生产任务数据");
    }

    /**
     * 新增MES生产任务
     */
    @RequiresPermissions("manufacture:MesTask:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存MES生产任务
     */
    @RequiresPermissions("manufacture:MesTask:add")
    @Log(title = "MES生产任务", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MesTask mesTask)
    {
        return toAjax(mesTaskService.insertMesTask(mesTask));
    }

    /**
     * 修改MES生产任务
     */
    @RequiresPermissions("manufacture:MesTask:edit")
    @GetMapping("/edit/{taskId}")
    public String edit(@PathVariable("taskId") Long taskId, ModelMap mmap)
    {
        MesTask mesTask = mesTaskService.selectMesTaskByTaskId(taskId);
        mmap.put("mesTask", mesTask);
        return prefix + "/edit";
    }

    /**
     * 修改保存MES生产任务
     */
    @RequiresPermissions("manufacture:MesTask:edit")
    @Log(title = "MES生产任务", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MesTask mesTask)
    {
        return toAjax(mesTaskService.updateMesTask(mesTask));
    }

    /**
     * 删除MES生产任务
     */
    @RequiresPermissions("manufacture:MesTask:remove")
    @Log(title = "MES生产任务", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(mesTaskService.deleteMesTaskByTaskIds(ids));
    }


    /**
 * 开始生产
 */
@RequiresPermissions("manufacture:MesTask:edit")
@Log(title = "开始生产", businessType = BusinessType.UPDATE)
@PostMapping("/start/{taskId}")
@ResponseBody
public AjaxResult start(@PathVariable("taskId") Long taskId)
{

    MesTask mesTask =
            mesTaskService.selectMesTaskByTaskId(taskId);


    if(mesTask == null)
    {
        return AjaxResult.error("任务不存在");
    }


    if(!"0".equals(mesTask.getStatus()))
    {
        return AjaxResult.error("当前状态不能开始生产");
    }


    mesTask.setStatus("1");


    mesTaskService.updateMesTask(mesTask);


    return AjaxResult.success("开始生产成功");
}

/**
 * 完工
 */
@RequiresPermissions("manufacture:MesTask:edit")
@Log(title = "生产完工", businessType = BusinessType.UPDATE)
@PostMapping("/complete/{taskId}")
@ResponseBody
public AjaxResult complete(@PathVariable("taskId") Long taskId)
{

    MesTask mesTask =
            mesTaskService.selectMesTaskByTaskId(taskId);


    if(mesTask == null)
    {
        return AjaxResult.error("任务不存在");
    }


    if(!"1".equals(mesTask.getStatus()))
    {
        return AjaxResult.error("当前状态不能完工");
    }



    /*
     * 1. MES任务完成
     */

    mesTask.setStatus("2");

    mesTaskService.updateMesTask(mesTask);



    /*
     * 2. 生成入库记录
     */

    StockIn stockIn = new StockIn();

    stockIn.setProductId(
            mesTask.getProductId()
    );

    stockIn.setQuantity(
            mesTask.getQuantity()
    );


    stockIn.setSourceTaskId(
            mesTask.getTaskId()
    );


    stockInService.insertStockIn(stockIn);



    /*
     * 3. 更新库存
     */


    Inventory inventory =
            inventoryService.selectInventoryByProductId(
                    mesTask.getProductId()
            );


    if(inventory == null)
    {

        // 第一次生产该产品
        inventory = new Inventory();

        inventory.setProductId(
                mesTask.getProductId()
        );

        inventory.setQuantity(
                mesTask.getQuantity()
        );

        inventoryService.insertInventory(inventory);

    }
    else
    {

        BigDecimal newQuantity =
                inventory.getQuantity()
                .add(mesTask.getQuantity());


        inventory.setQuantity(newQuantity);


        inventoryService.updateInventory(inventory);

    }



    return AjaxResult.success("生产完成，已入库");
}
}
