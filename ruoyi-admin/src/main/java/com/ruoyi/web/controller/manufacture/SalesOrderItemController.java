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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SalesOrderItem;
import com.ruoyi.system.service.ISalesOrderItemService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 销售订单明细Controller
 *
 * @author Mingjian Sun
 * @date 2026-08-18
 */
@Controller
@RequestMapping("/manufacture/item")
public class SalesOrderItemController extends BaseController
{
    private String prefix = "manufacture/item";

    @Autowired
    private ISalesOrderItemService salesOrderItemService;

    /**
     * 销售订单明细页面
     *
     * orderId为当前销售订单ID。
     */
    @RequiresPermissions("manufacture:item:view")
    @GetMapping()
    public String item(
            @RequestParam(value = "orderId", required = false) Long orderId,
            ModelMap mmap)
    {
        mmap.put("orderId", orderId);
        return prefix + "/item";
    }

    /**
     * 查询销售订单明细列表
     */
    @RequiresPermissions("manufacture:item:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SalesOrderItem salesOrderItem)
    {
        startPage();

        List<SalesOrderItem> list =
                salesOrderItemService.selectSalesOrderItemList(salesOrderItem);

        return getDataTable(list);
    }

    /**
     * 导出销售订单明细列表
     */
    @RequiresPermissions("manufacture:item:export")
    @Log(title = "销售订单明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SalesOrderItem salesOrderItem)
    {
        List<SalesOrderItem> list =
                salesOrderItemService.selectSalesOrderItemList(salesOrderItem);

        ExcelUtil<SalesOrderItem> util =
                new ExcelUtil<SalesOrderItem>(SalesOrderItem.class);

        return util.exportExcel(list, "销售订单明细数据");
    }

    /**
     * 新增销售订单明细
     *
     * orderId从当前销售订单页面传递过来。
     */
    @RequiresPermissions("manufacture:item:add")
    @GetMapping("/add")
    public String add(
            @RequestParam(value = "orderId", required = false) Long orderId,
            ModelMap mmap)
    {
        mmap.put("orderId", orderId);
        return prefix + "/add";
    }

    /**
     * 新增保存销售订单明细
     */
    @RequiresPermissions("manufacture:item:add")
    @Log(title = "销售订单明细", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SalesOrderItem salesOrderItem)
    {
        return toAjax(
                salesOrderItemService.insertSalesOrderItem(salesOrderItem)
        );
    }

    /**
     * 修改销售订单明细
     */
    @RequiresPermissions("manufacture:item:edit")
    @GetMapping("/edit/{itemId}")
    public String edit(
            @PathVariable("itemId") Long itemId,
            ModelMap mmap)
    {
        SalesOrderItem salesOrderItem =
                salesOrderItemService.selectSalesOrderItemByItemId(itemId);

        mmap.put("salesOrderItem", salesOrderItem);

        return prefix + "/edit";
    }

    /**
     * 修改保存销售订单明细
     */
    @RequiresPermissions("manufacture:item:edit")
    @Log(title = "销售订单明细", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SalesOrderItem salesOrderItem)
    {
        return toAjax(
                salesOrderItemService.updateSalesOrderItem(salesOrderItem)
        );
    }

    /**
     * 删除销售订单明细
     */
    @RequiresPermissions("manufacture:item:remove")
    @Log(title = "销售订单明细", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(
                salesOrderItemService.deleteSalesOrderItemByItemIds(ids)
        );
    }
}