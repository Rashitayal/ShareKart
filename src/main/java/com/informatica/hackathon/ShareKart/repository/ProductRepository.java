package com.informatica.hackathon.ShareKart.repository;

import com.informatica.hackathon.ShareKart.model.Product;
import com.informatica.hackathon.ShareKart.model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("select p from Product p where p.subCategory.id IN :subCatId")
    List<Product> findProductBySubCatId(@Param("subCatId") List<Integer> subCatId);

    @Query("select p from Product p where p.id IN :prodId")
    List<Product> findProductById(@Param("prodId") List<Integer> prodId);

    @Query("select p.id from Product p where p.subCategory.id IN :subCatId")
    List<Integer> findProductIds(@Param("subCatId") List<Integer> subCatId);

    @Query("select p from Product p where p.id NOT IN :prodId")
    List<Product> findProductsToExclude(@Param("prodId") List<Integer> prodId);

    @Query("select p.id from Product p where p.name = :dbname")
    List<Integer> findProductsbyName(@Param("dbname") String dbname);

}
