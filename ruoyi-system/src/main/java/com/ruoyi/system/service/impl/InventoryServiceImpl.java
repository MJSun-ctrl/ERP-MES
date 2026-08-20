package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.InventoryMapper;
import com.ruoyi.system.domain.Inventory;
import com.ruoyi.system.service.IInventoryService;
import com.ruoyi.common.core.text.Convert;

/**
 * 库存Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-08-19
 */
@Service
public class InventoryServiceImpl implements IInventoryService 
{
    @Autowired
    private InventoryMapper inventoryMapper;

    /**
     * 查询库存
     * 
     * @param inventoryId 库存主键
     * @return 库存
     */
    @Override
    public Inventory selectInventoryByInventoryId(Long inventoryId)
    {
        return inventoryMapper.selectInventoryByInventoryId(inventoryId);
    }


    @Override
public Inventory selectInventoryByProductId(Long productId)
{
    return inventoryMapper.selectInventoryByProductId(productId);
}

    /**
     * 查询库存列表
     * 
     * @param inventory 库存
     * @return 库存
     */
    @Override
    public List<Inventory> selectInventoryList(Inventory inventory)
    {
        return inventoryMapper.selectInventoryList(inventory);
    }

    /**
     * 新增库存
     * 
     * @param inventory 库存
     * @return 结果
     */
    @Override
    public int insertInventory(Inventory inventory)
    {
        inventory.setCreateTime(DateUtils.getNowDate());
        return inventoryMapper.insertInventory(inventory);
    }

    /**
     * 修改库存
     * 
     * @param inventory 库存
     * @return 结果
     */
    @Override
    public int updateInventory(Inventory inventory)
    {
        inventory.setUpdateTime(DateUtils.getNowDate());
        return inventoryMapper.updateInventory(inventory);
    }

    /**
     * 批量删除库存
     * 
     * @param inventoryIds 需要删除的库存主键
     * @return 结果
     */
    @Override
    public int deleteInventoryByInventoryIds(String inventoryIds)
    {
        return inventoryMapper.deleteInventoryByInventoryIds(Convert.toStrArray(inventoryIds));
    }

    /**
     * 删除库存信息
     * 
     * @param inventoryId 库存主键
     * @return 结果
     */
    @Override
    public int deleteInventoryByInventoryId(Long inventoryId)
    {
        return inventoryMapper.deleteInventoryByInventoryId(inventoryId);
    }
}
