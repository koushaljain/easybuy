package com.easybuy.controller;

import com.easybuy.service.ProductService;
import com.easybuy.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/easybuy")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/Products")
    public ResponseEntity<List<ProductVO>> getAllProducts() {
        List<ProductVO> productsVO = productService.getAllProducts();
        return new ResponseEntity<>(productsVO, HttpStatus.OK);
    }


}
