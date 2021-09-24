package com.informatica.hackathon.ShareKart.service.impl;

import com.informatica.hackathon.ShareKart.model.Category;
import com.informatica.hackathon.ShareKart.repository.CategoryRepository;
import com.informatica.hackathon.ShareKart.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category getCategory(Integer catId) {
        return categoryRepository.findCatByCategoryId(catId);
    }
}
