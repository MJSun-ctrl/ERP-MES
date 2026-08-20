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
import com.ruoyi.system.domain.Bom;
import com.ruoyi.system.service.IBomService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

import com.ruoyi.system.domain.Product;
import com.ruoyi.system.service.IProductService;
/**
 * 物料清单Controller
 * 
 * @author Mingjian Sun
 * @date 2026-08-17
 */
@Controller
@RequestMapping("/manufacture/bom")
public class BomController extends BaseController
{
    private String prefix = "manufacture/bom";

    @Autowired
    private IBomService bomService;
    @Autowired
private IProductService productService;

    @RequiresPermissions("manufacture:bom:view")
    @GetMapping()
    public String bom()
    {
        return prefix + "/bom";
    }

    /**
     * 查询物料清单列表
     */
    @RequiresPermissions("manufacture:bom:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Bom bom)
    {
        startPage();
        List<Bom> list = bomService.selectBomList(bom);
        return getDataTable(list);
    }

    /**
     * 导出物料清单列表
     */
    @RequiresPermissions("manufacture:bom:export")
    @Log(title = "物料清单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Bom bom)
    {
        List<Bom> list = bomService.selectBomList(bom);
        ExcelUtil<Bom> util = new ExcelUtil<Bom>(Bom.class);
        return util.exportExcel(list, "物料清单数据");
    }

    /**
     * 新增物料清单
     */
    @RequiresPermissions("manufacture:bom:add")
@GetMapping("/add")
public String add(ModelMap mmap)
{
    List<Product> products = productService.selectProductList(new Product());

    mmap.put("products", products);

    return prefix + "/add";
}

    /**
     * 新增保存物料清单
     */
    @RequiresPermissions("manufacture:bom:add")
    @Log(title = "物料清单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Bom bom)
    {
        return toAjax(bomService.insertBom(bom));
    }

    /**
     * 修改物料清单
     */
    @RequiresPermissions("manufacture:bom:edit")
@GetMapping("/edit/{bomId}")
public String edit(@PathVariable("bomId") Long bomId, ModelMap mmap)
{

    Bom bom = bomService.selectBomByBomId(bomId);

    List<Product> products =
        productService.selectProductList(new Product());


    mmap.put("bom", bom);
    mmap.put("products", products);


    return prefix + "/edit";
}

    /**
     * 修改保存物料清单
     */
    @RequiresPermissions("manufacture:bom:edit")
    @Log(title = "物料清单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Bom bom)
    {
        return toAjax(bomService.updateBom(bom));
    }

    /**
     * 删除物料清单
     */
    @RequiresPermissions("manufacture:bom:remove")
    @Log(title = "物料清单", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(bomService.deleteBomByBomIds(ids));
    }
}
