package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Bom;

/**
 * 物料清单Service接口
 * 
 * @author ruoyi
 * @date 2026-08-17
 */
public interface IBomService 
{
    /**
     * 查询物料清单
     * 
     * @param bomId 物料清单主键
     * @return 物料清单
     */
    public Bom selectBomByBomId(Long bomId);

    /**
     * 查询物料清单列表
     * 
     * @param bom 物料清单
     * @return 物料清单集合
     */
    public List<Bom> selectBomList(Bom bom);

    /**
     * 新增物料清单
     * 
     * @param bom 物料清单
     * @return 结果
     */
    public int insertBom(Bom bom);

    /**
     * 修改物料清单
     * 
     * @param bom 物料清单
     * @return 结果
     */
    public int updateBom(Bom bom);

    /**
     * 批量删除物料清单
     * 
     * @param bomIds 需要删除的物料清单主键集合
     * @return 结果
     */
    public int deleteBomByBomIds(String bomIds);

    /**
     * 删除物料清单信息
     * 
     * @param bomId 物料清单主键
     * @return 结果
     */
    public int deleteBomByBomId(Long bomId);
}
