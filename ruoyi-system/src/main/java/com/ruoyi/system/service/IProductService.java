package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Product;

/**
 * 产品管理Service接口
 * 
 * @author ruoyi
 * @date 2026-08-16
 */
public interface IProductService 
{
    /**
     * 查询产品管理
     * 
     * @param productId 产品管理主键
     * @return 产品管理
     */
    public Product selectProductByProductId(Long productId);

    /**
     * 查询产品管理列表
     * 
     * @param product 产品管理
     * @return 产品管理集合
     */
    public List<Product> selectProductList(Product product);

    /**
     * 新增产品管理
     * 
     * @param product 产品管理
     * @return 结果
     */
    public int insertProduct(Product product);

    /**
     * 修改产品管理
     * 
     * @param product 产品管理
     * @return 结果
     */
    public int updateProduct(Product product);

    /**
     * 批量删除产品管理
     * 
     * @param productIds 需要删除的产品管理主键集合
     * @return 结果
     */
    public int deleteProductByProductIds(String productIds);

    /**
     * 删除产品管理信息
     * 
     * @param productId 产品管理主键
     * @return 结果
     */
    public int deleteProductByProductId(Long productId);
}
