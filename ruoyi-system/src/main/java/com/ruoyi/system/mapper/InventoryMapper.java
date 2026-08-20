package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Inventory;

/**
 * 库存Mapper接口
 * 
 * @author Mingjian Sun
 * @date 2026-08-19
 */
public interface InventoryMapper 
{
    /**
     * 查询库存
     * 
     * @param inventoryId 库存主键
     * @return 库存
     */
    public Inventory selectInventoryByInventoryId(Long inventoryId);

    /**
 * 根据产品ID查询库存
 */
public Inventory selectInventoryByProductId(Long productId);

    /**
     * 查询库存列表
     * 
     * @param inventory 库存
     * @return 库存集合
     */
    public List<Inventory> selectInventoryList(Inventory inventory);

    /**
     * 新增库存
     * 
     * @param inventory 库存
     * @return 结果
     */
    public int insertInventory(Inventory inventory);

    /**
     * 修改库存
     * 
     * @param inventory 库存
     * @return 结果
     */
    public int updateInventory(Inventory inventory);

    /**
     * 删除库存
     * 
     * @param inventoryId 库存主键
     * @return 结果
     */
    public int deleteInventoryByInventoryId(Long inventoryId);

    /**
     * 批量删除库存
     * 
     * @param inventoryIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteInventoryByInventoryIds(String[] inventoryIds);
}
