package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.BomDetail;

/**
 * 物料清单明细Mapper接口
 * 
 * @author Mingjian Sun
 * @date 2026-08-18
 */
public interface BomDetailMapper 
{
    /**
     * 查询物料清单明细
     * 
     * @param detailId 物料清单明细主键
     * @return 物料清单明细
     */
    public BomDetail selectBomDetailByDetailId(Long detailId);

    /**
     * 查询物料清单明细列表
     * 
     * @param bomDetail 物料清单明细
     * @return 物料清单明细集合
     */
    public List<BomDetail> selectBomDetailList(BomDetail bomDetail);

    /**
     * 新增物料清单明细
     * 
     * @param bomDetail 物料清单明细
     * @return 结果
     */
    public int insertBomDetail(BomDetail bomDetail);

    /**
     * 修改物料清单明细
     * 
     * @param bomDetail 物料清单明细
     * @return 结果
     */
    public int updateBomDetail(BomDetail bomDetail);

    /**
     * 删除物料清单明细
     * 
     * @param detailId 物料清单明细主键
     * @return 结果
     */
    public int deleteBomDetailByDetailId(Long detailId);

    /**
     * 批量删除物料清单明细
     * 
     * @param detailIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBomDetailByDetailIds(String[] detailIds);
}
