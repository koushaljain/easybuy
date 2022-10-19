package com.easybuy.service;

import com.easybuy.model.Category;
import com.easybuy.repository.CategoryRepository;
import com.easybuy.vo.CategoryVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public List<CategoryVO> getAllCategorys() {
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
}
