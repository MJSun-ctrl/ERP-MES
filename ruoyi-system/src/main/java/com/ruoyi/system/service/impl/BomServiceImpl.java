package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BomMapper;
import com.ruoyi.system.domain.Bom;
import com.ruoyi.system.service.IBomService;
import com.ruoyi.common.core.text.Convert;

/**
 * 物料清单Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-08-17
 */
@Service
public class BomServiceImpl implements IBomService 
{
    @Autowired
    private BomMapper bomMapper;

    /**
     * 查询物料清单
     * 
     * @param bomId 物料清单主键
     * @return 物料清单
     */
    @Override
    public Bom selectBomByBomId(Long bomId)
    {
        return bomMapper.selectBomByBomId(bomId);
    }

    /**
     * 查询物料清单列表
     * 
     * @param bom 物料清单
     * @return 物料清单
     */
    @Override
    public List<Bom> selectBomList(Bom bom)
    {
        return bomMapper.selectBomList(bom);
    }

    /**
     * 新增物料清单
     * 
     * @param bom 物料清单
     * @return 结果
     */
    @Override
    public int insertBom(Bom bom)
    {
        bom.setCreateTime(DateUtils.getNowDate());
        return bomMapper.insertBom(bom);
    }

    /**
     * 修改物料清单
     * 
     * @param bom 物料清单
     * @return 结果
     */
    @Override
    public int updateBom(Bom bom)
    {
        bom.setUpdateTime(DateUtils.getNowDate());
        return bomMapper.updateBom(bom);
    }

    /**
     * 批量删除物料清单
     * 
     * @param bomIds 需要删除的物料清单主键
     * @return 结果
     */
    @Override
    public int deleteBomByBomIds(String bomIds)
    {
        return bomMapper.deleteBomByBomIds(Convert.toStrArray(bomIds));
    }

    /**
     * 删除物料清单信息
     * 
     * @param bomId 物料清单主键
     * @return 结果
     */
    @Override
    public int deleteBomByBomId(Long bomId)
    {
        return bomMapper.deleteBomByBomId(bomId);
    }
}
