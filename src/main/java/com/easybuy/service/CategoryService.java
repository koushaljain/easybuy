package com.easybuy.service;

import com.easybuy.model.Category;
import com.easybuy.model.Product;
import com.easybuy.repository.CategoryRepository;
import com.easybuy.vo.CategoryVO;
import com.easybuy.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public List<CategoryVO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryVO> categoriesVO = new ArrayList<>();
        for (Category category : categories) {
            CategoryVO categoryVO = new CategoryVO();
            categoryVO.setCategoryId(category.getCategoryId());
            categoryVO.setCategoryName(category.getCategoryName());
            categoriesVO.add(categoryVO);
        }
        return categoriesVO;
    }

    public Integer saveCategory(CategoryVO categoryVO){
        Category category = new Category();
        category.setCategoryName(categoryVO.getCategoryName());
        Category savedCategory = categoryRepository.save(category);
        return savedCategory.getCategoryId();
    }
}
