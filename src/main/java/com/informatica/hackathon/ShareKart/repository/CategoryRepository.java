package com.informatica.hackathon.ShareKart.repository;

import com.informatica.hackathon.ShareKart.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query("select c from Category c where c.name = :catname")
    Category findCatByCatId(@Param("catname") String categoryName);

}
