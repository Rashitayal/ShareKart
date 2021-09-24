package com.informatica.hackathon.ShareKart.repository;

import com.informatica.hackathon.ShareKart.model.Likes;
import com.informatica.hackathon.ShareKart.model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LikesRepository extends JpaRepository<Likes, Integer> {

    @Query("select l.subCategory.id from Likes l where l.profile.id = :profileId")
    List<Integer> findSubcatIdByProfileId(@Param("profileId") String profileId);

    @Query("select l.category.id from Likes l where l.profile.id = :profileId")
    List<Integer> findCatIdByProfileId(@Param("profileId") String profileId);

    @Query("select l from Likes l JOIN l.category c where l.profile.id = :profileId and c.id IN :catId")
    List<Likes> findlikesByProfileIdAndCatId(@Param("profileId") String profileId, @Param("catId") List<Integer> catId);

    @Query("select s.id from Likes l JOIN l.subCategory s where l.profile.id = :profileId and s.id IN :subCatId")
    List<Integer> findlikesByProfileIdAndSubCatId(@Param("profileId") String profileId, @Param("subCatId") List<Integer> subCatId);

    @Query("select p.id from Likes l JOIN l.product p where l.profile.id = :profileId and p.id IN :prodId")
    List<Integer> findlikesByProfileIdAndProdId(@Param("profileId") String profileId, @Param("prodId") List<Integer> prodId);

}
