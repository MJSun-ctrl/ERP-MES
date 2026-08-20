package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BomDetailMapper;
import com.ruoyi.system.domain.BomDetail;
import com.ruoyi.system.service.IBomDetailService;
import com.ruoyi.common.core.text.Convert;

/**
 * 物料清单明细Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-08-18
 */
@Service
public class BomDetailServiceImpl implements IBomDetailService 
{
    @Autowired
    private BomDetailMapper bomDetailMapper;

    /**
     * 查询物料清单明细
     * 
     * @param detailId 物料清单明细主键
     * @return 物料清单明细
     */
    @Override
    public BomDetail selectBomDetailByDetailId(Long detailId)
    {
        return bomDetailMapper.selectBomDetailByDetailId(detailId);
    }

    /**
     * 查询物料清单明细列表
     * 
     * @param bomDetail 物料清单明细
     * @return 物料清单明细
     */
    @Override
    public List<BomDetail> selectBomDetailList(BomDetail bomDetail)
    {
        return bomDetailMapper.selectBomDetailList(bomDetail);
    }

    /**
     * 新增物料清单明细
     * 
     * @param bomDetail 物料清单明细
     * @return 结果
     */
    @Override
    public int insertBomDetail(BomDetail bomDetail)
    {
        return bomDetailMapper.insertBomDetail(bomDetail);
    }

    /**
     * 修改物料清单明细
     * 
     * @param bomDetail 物料清单明细
     * @return 结果
     */
    @Override
    public int updateBomDetail(BomDetail bomDetail)
    {
        return bomDetailMapper.updateBomDetail(bomDetail);
    }

    /**
     * 批量删除物料清单明细
     * 
     * @param detailIds 需要删除的物料清单明细主键
     * @return 结果
     */
    @Override
    public int deleteBomDetailByDetailIds(String detailIds)
    {
        return bomDetailMapper.deleteBomDetailByDetailIds(Convert.toStrArray(detailIds));
    }

    /**
     * 删除物料清单明细信息
     * 
     * @param detailId 物料清单明细主键
     * @return 结果
     */
    @Override
    public int deleteBomDetailByDetailId(Long detailId)
    {
        return bomDetailMapper.deleteBomDetailByDetailId(detailId);
    }
}
