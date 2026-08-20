package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Material;

/**
 * 物料信息Service接口
 * 
 * @author ruoyi
 * @date 2026-08-17
 */
public interface IMaterialService 
{
    /**
     * 查询物料信息
     * 
     * @param materialId 物料信息主键
     * @return 物料信息
     */
    public Material selectMaterialByMaterialId(Long materialId);

    /**
     * 查询物料信息列表
     * 
     * @param material 物料信息
     * @return 物料信息集合
     */
    public List<Material> selectMaterialList(Material material);

    /**
     * 新增物料信息
     * 
     * @param material 物料信息
     * @return 结果
     */
    public int insertMaterial(Material material);

    /**
     * 修改物料信息
     * 
     * @param material 物料信息
     * @return 结果
     */
    public int updateMaterial(Material material);

    /**
     * 批量删除物料信息
     * 
     * @param materialIds 需要删除的物料信息主键集合
     * @return 结果
     */
    public int deleteMaterialByMaterialIds(String materialIds);

    /**
     * 删除物料信息信息
     * 
     * @param materialId 物料信息主键
     * @return 结果
     */
    public int deleteMaterialByMaterialId(Long materialId);
}
