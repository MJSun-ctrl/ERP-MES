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
import com.ruoyi.system.domain.Material;
import com.ruoyi.system.service.IMaterialService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 物料信息Controller
 * 
 * @author Mingjian Sun
 * @date 2026-08-17
 */
@Controller
@RequestMapping("/manufacture/material")
public class MaterialController extends BaseController
{
    private String prefix = "manufacture/material";

    @Autowired
    private IMaterialService materialService;

    @RequiresPermissions("manufacture:material:view")
    @GetMapping()
    public String material()
    {
        return prefix + "/material";
    }

    /**
     * 查询物料信息列表
     */
    @RequiresPermissions("manufacture:material:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Material material)
    {
        startPage();
        List<Material> list = materialService.selectMaterialList(material);
        return getDataTable(list);
    }

    /**
     * 导出物料信息列表
     */
    @RequiresPermissions("manufacture:material:export")
    @Log(title = "物料信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Material material)
    {
        List<Material> list = materialService.selectMaterialList(material);
        ExcelUtil<Material> util = new ExcelUtil<Material>(Material.class);
        return util.exportExcel(list, "物料信息数据");
    }

    /**
     * 新增物料信息
     */
    @RequiresPermissions("manufacture:material:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存物料信息
     */
    @RequiresPermissions("manufacture:material:add")
    @Log(title = "物料信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Material material)
    {
        return toAjax(materialService.insertMaterial(material));
    }

    /**
     * 修改物料信息
     */
    @RequiresPermissions("manufacture:material:edit")
    @GetMapping("/edit/{materialId}")
    public String edit(@PathVariable("materialId") Long materialId, ModelMap mmap)
    {
        Material material = materialService.selectMaterialByMaterialId(materialId);
        mmap.put("material", material);
        return prefix + "/edit";
    }

    /**
     * 修改保存物料信息
     */
    @RequiresPermissions("manufacture:material:edit")
    @Log(title = "物料信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Material material)
    {
        return toAjax(materialService.updateMaterial(material));
    }

    /**
     * 删除物料信息
     */
    @RequiresPermissions("manufacture:material:remove")
    @Log(title = "物料信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(materialService.deleteMaterialByMaterialIds(ids));
    }
}
