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
import com.ruoyi.system.domain.StockIn;
import com.ruoyi.system.service.IStockInService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 入库记录Controller
 * 
 * @author Mingjian Sun
 * @date 2026-08-19
 */
@Controller
@RequestMapping("/manufacture/stockin")
public class StockInController extends BaseController
{
    private String prefix = "manufacture/stockin";

    @Autowired
    private IStockInService stockInService;

    @RequiresPermissions("manufacture:stockin:view")
    @GetMapping()
    public String stockin()
    {
        return prefix + "/stockin";
    }

    /**
     * 查询入库记录列表
     */
    @RequiresPermissions("manufacture:stockin:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(StockIn stockIn)
    {
        startPage();
        List<StockIn> list = stockInService.selectStockInList(stockIn);
        return getDataTable(list);
    }

    /**
     * 导出入库记录列表
     */
    @RequiresPermissions("manufacture:stockin:export")
    @Log(title = "入库记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(StockIn stockIn)
    {
        List<StockIn> list = stockInService.selectStockInList(stockIn);
        ExcelUtil<StockIn> util = new ExcelUtil<StockIn>(StockIn.class);
        return util.exportExcel(list, "入库记录数据");
    }

    /**
     * 新增入库记录
     */
    @RequiresPermissions("manufacture:stockin:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存入库记录
     */
    @RequiresPermissions("manufacture:stockin:add")
    @Log(title = "入库记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(StockIn stockIn)
    {
        return toAjax(stockInService.insertStockIn(stockIn));
    }

    /**
     * 修改入库记录
     */
    @RequiresPermissions("manufacture:stockin:edit")
    @GetMapping("/edit/{stockId}")
    public String edit(@PathVariable("stockId") Long stockId, ModelMap mmap)
    {
        StockIn stockIn = stockInService.selectStockInByStockId(stockId);
        mmap.put("stockIn", stockIn);
        return prefix + "/edit";
    }

    /**
     * 修改保存入库记录
     */
    @RequiresPermissions("manufacture:stockin:edit")
    @Log(title = "入库记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(StockIn stockIn)
    {
        return toAjax(stockInService.updateStockIn(stockIn));
    }

    /**
     * 删除入库记录
     */
    @RequiresPermissions("manufacture:stockin:remove")
    @Log(title = "入库记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(stockInService.deleteStockInByStockIds(ids));
    }
}
