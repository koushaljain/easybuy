package com.easybuy.service;

import com.easybuy.vo.CategoryVO;
import com.easybuy.vo.InventoryAddVO;
import com.easybuy.vo.ProductVO;
import com.easybuy.vo.StockVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    @Autowired
    CategoryService categoryService;

    @Autowired
    StockService stockService;

    @Autowired
    ProductService productService;

    public Integer addInventory(InventoryAddVO inventoryAddVO) {
        Integer categoryId = inventoryAddVO.getCategoryId();

        StockVO stockVO = new StockVO();
        stockVO.setStockCount(inventoryAddVO.getStockCount());
        Integer stockId = stockService.saveStock(stockVO);

        ProductVO productVO = new ProductVO();
        productVO.setProductName(inventoryAddVO.getProductName());

        productVO.setCategoryId(categoryId);
        productVO.setStockId(stockId);

        Integer productId = productService.saveProduct(productVO);
        return productId;
    }
}
