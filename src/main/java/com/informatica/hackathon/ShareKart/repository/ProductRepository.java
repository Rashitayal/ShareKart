package com.informatica.hackathon.ShareKart.repository;

import com.informatica.hackathon.ShareKart.model.Product;
import com.informatica.hackathon.ShareKart.model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("select p from Product p where p.subCategory.id IN (:subCatId) and (p.classification is null or p.classification = :gender)")
    List<Product> findProductBySubCatId(@Param("subCatId") List<Integer> subCatId, @Param("gender") String gender);

    @Query("select p from Product p where p.id IN :prodId and (p.classification is null or p.classification = :gender)")
    List<Product> findProductById(@Param("prodId") List<Integer> prodId, @Param("gender") String gender);

    @Query("select p.id from Product p JOIN p.subCategory s where s.id IN :subCatId and (p.classification is null or p.classification = :gender)")
    List<Integer> findProductIds(@Param("subCatId") List<Integer> subCatId, @Param("gender") String gender);

    @Query("select p from Product p where p.id NOT IN :prodId and (p.classification is null or p.classification = :gender)")
    List<Product> findProductsToExclude(@Param("prodId") List<Integer> prodId, @Param("gender") String gender);

    @Query("select p from Product p JOIN p.subCategory sc where p.id NOT IN :prodId and sc.id IN :subCatId")
    List<Product> findProductsToExcludeBySearch(@Param("prodId") List<Integer> prodId,@Param("subCatId") List<Integer> subCatId);

    @Query("select p.id from Product p where p.name = :dbname and (p.classification is null or p.classification = :gender)")
    List<Integer> findProductsbyName(@Param("dbname") String dbname, @Param("gender") String gender);

    @Query("select p.subCategory.id from Product p where p.name = :dbname and (p.classification is null or p.classification = :gender)")
    List<Integer> findSubCatByProdName(@Param("dbname") String dbname, @Param("gender") String gender);

}
