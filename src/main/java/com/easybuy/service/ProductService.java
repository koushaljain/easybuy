package com.easybuy.service;

import com.easybuy.model.Product;
import com.easybuy.repository.ProductRepository;
import com.easybuy.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<ProductVO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductVO> productsVO = new ArrayList<>();
        for (Product product : products) {
            ProductVO productVO = new ProductVO();
            productVO.setProductId(product.getProductId());
            productVO.setProductName(product.getProductName());
            productVO.setProductPrice(product.getProductPrice());
            productVO.setCategoryId(product.getCategoryId());
            productVO.setStockId(product.getStockId());
            productsVO.add(productVO);
        }
        return productsVO;
    }

    public Integer saveProduct(ProductVO productVO){
        Product product = new Product();
        productVO.setProductName(product.getProductName());
        productVO.setProductPrice(product.getProductPrice());
        productVO.setCategoryId(product.getCategoryId());
        productVO.setStockId(product.getStockId());
        Product savedProduct = productRepository.save(product);
        return savedProduct.getProductId();
    }
}
