package com.easybuy.controller;

import com.easybuy.service.CategoryService;
import com.easybuy.vo.CategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/easybuy")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/Categories")
    public ResponseEntity<List<CategoryVO>> getAllCategories() {
        List<CategoryVO> categoriesVO = categoryService.getAllCategories();
        return new ResponseEntity<>(categoriesVO, HttpStatus.OK);
    }

    @PostMapping("/Categories")
    public ResponseEntity<Integer> saveCategory(@RequestBody CategoryVO categoryVO) {
        Integer savedId = categoryService.saveCategory(categoryVO);
        return new ResponseEntity<>(savedId, HttpStatus.CREATED);
    }
}
