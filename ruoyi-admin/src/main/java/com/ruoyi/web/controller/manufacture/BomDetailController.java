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
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.poi.ExcelUtil;

import com.ruoyi.system.domain.BomDetail;
import com.ruoyi.system.domain.Material;
import com.ruoyi.system.service.IBomDetailService;
import com.ruoyi.system.service.IMaterialService;

/**
 * 物料清单明细Controller
 *
 * @author Mingjian Sun
 * @date 2026-08-18
 */
@Controller
@RequestMapping("/manufacture/bomDetail")
public class BomDetailController extends BaseController
{
    private String prefix = "manufacture/bomDetail";

    @Autowired
    private IBomDetailService bomDetailService;

    @Autowired
    private IMaterialService materialService;

    /**
     * 物料清单明细页面
     */
    @RequiresPermissions("manufacture:bomDetail:view")
    @GetMapping()
    public String bomDetail(Long bomId, ModelMap mmap)
    {
        mmap.put("bomId", bomId);
        return prefix + "/bomDetail";
    }

    /**
     * 查询物料清单明细列表
     */
    @RequiresPermissions("manufacture:bomDetail:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BomDetail bomDetail)
    {
        startPage();

        List<BomDetail> list =
                bomDetailService.selectBomDetailList(bomDetail);

        return getDataTable(list);
    }

    /**
     * 导出物料清单明细列表
     */
    @RequiresPermissions("manufacture:bomDetail:export")
    @Log(title = "物料清单明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BomDetail bomDetail)
    {
        List<BomDetail> list =
                bomDetailService.selectBomDetailList(bomDetail);

        ExcelUtil<BomDetail> util =
                new ExcelUtil<BomDetail>(BomDetail.class);

        return util.exportExcel(list, "物料清单明细数据");
    }

    /**
     * 新增物料清单明细
     *
     * bomId 从当前BOM页面传入
     */
    @RequiresPermissions("manufacture:bomDetail:add")
    @GetMapping("/add")
    public String add(Long bomId, ModelMap mmap)
    {
        mmap.put("bomId", bomId);

        // 查询所有物料，供新增明细时选择
        List<Material> materials =
                materialService.selectMaterialList(new Material());

        mmap.put("materials", materials);

        return prefix + "/add";
    }

    /**
     * 新增保存物料清单明细
     */
    @RequiresPermissions("manufacture:bomDetail:add")
    @Log(title = "物料清单明细", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BomDetail bomDetail)
    {
        return toAjax(
                bomDetailService.insertBomDetail(bomDetail)
        );
    }

    /**
     * 修改物料清单明细
     */
    @RequiresPermissions("manufacture:bomDetail:edit")
    @GetMapping("/edit/{detailId}")
    public String edit(
            @PathVariable("detailId") Long detailId,
            ModelMap mmap)
    {
        BomDetail bomDetail =
                bomDetailService.selectBomDetailByDetailId(detailId);

        mmap.put("bomDetail", bomDetail);

        // 修改时同样需要物料下拉框
        List<Material> materials =
                materialService.selectMaterialList(new Material());

        mmap.put("materials", materials);

        return prefix + "/edit";
    }

    /**
     * 修改保存物料清单明细
     */
    @RequiresPermissions("manufacture:bomDetail:edit")
    @Log(title = "物料清单明细", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BomDetail bomDetail)
    {
        return toAjax(
                bomDetailService.updateBomDetail(bomDetail)
        );
    }

    /**
     * 删除物料清单明细
     */
    @RequiresPermissions("manufacture:bomDetail:remove")
    @Log(title = "物料清单明细", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(
                bomDetailService.deleteBomDetailByDetailIds(ids)
        );
    }

    /**
     * 根据BOM查询明细
     *
     * 为后续MES生产执行预留接口。
     */
    @RequiresPermissions("manufacture:bomDetail:list")
    @GetMapping("/listByBom/{bomId}")
    @ResponseBody
    public List<BomDetail> listByBom(
            @PathVariable("bomId") Long bomId)
    {
        BomDetail bomDetail = new BomDetail();
        bomDetail.setBomId(bomId);

        return bomDetailService.selectBomDetailList(bomDetail);
    }
}