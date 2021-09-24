package com.informatica.hackathon.ShareKart.repository;

import com.informatica.hackathon.ShareKart.model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Integer> {

    @Query("select sc from SubCategory sc where sc.name = :subname and sc.category.name = :catname")
    SubCategory findSubCatSubCatAndCatId(@Param("subname") String subCategoryName,
                                         @Param("catname") String categoryName);

    @Query("select sc.id from SubCategory sc JOIN sc.category c where c.id IN :catId")
    List<Integer> findSubcatByCatId(@Param("catId") List<Integer> catId);

    @Query("select sc.id from SubCategory sc where sc.name = :name")
    List<Integer> findSubcatByName(@Param("name") String name);

}
