package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.MaterialMapper;
import com.ruoyi.system.domain.Material;
import com.ruoyi.system.service.IMaterialService;
import com.ruoyi.common.core.text.Convert;

/**
 * 物料信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-08-17
 */
@Service
public class MaterialServiceImpl implements IMaterialService 
{
    @Autowired
    private MaterialMapper materialMapper;

    /**
     * 查询物料信息
     * 
     * @param materialId 物料信息主键
     * @return 物料信息
     */
    @Override
    public Material selectMaterialByMaterialId(Long materialId)
    {
        return materialMapper.selectMaterialByMaterialId(materialId);
    }

    /**
     * 查询物料信息列表
     * 
     * @param material 物料信息
     * @return 物料信息
     */
    @Override
    public List<Material> selectMaterialList(Material material)
    {
        return materialMapper.selectMaterialList(material);
    }

    /**
     * 新增物料信息
     * 
     * @param material 物料信息
     * @return 结果
     */
    @Override
    public int insertMaterial(Material material)
    {
        material.setCreateTime(DateUtils.getNowDate());
        return materialMapper.insertMaterial(material);
    }

    /**
     * 修改物料信息
     * 
     * @param material 物料信息
     * @return 结果
     */
    @Override
    public int updateMaterial(Material material)
    {
        material.setUpdateTime(DateUtils.getNowDate());
        return materialMapper.updateMaterial(material);
    }

    /**
     * 批量删除物料信息
     * 
     * @param materialIds 需要删除的物料信息主键
     * @return 结果
     */
    @Override
    public int deleteMaterialByMaterialIds(String materialIds)
    {
        return materialMapper.deleteMaterialByMaterialIds(Convert.toStrArray(materialIds));
    }

    /**
     * 删除物料信息信息
     * 
     * @param materialId 物料信息主键
     * @return 结果
     */
    @Override
    public int deleteMaterialByMaterialId(Long materialId)
    {
        return materialMapper.deleteMaterialByMaterialId(materialId);
    }
}
