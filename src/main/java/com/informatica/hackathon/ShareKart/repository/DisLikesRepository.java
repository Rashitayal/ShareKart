package com.informatica.hackathon.ShareKart.repository;

import com.informatica.hackathon.ShareKart.model.DisLikes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DisLikesRepository extends JpaRepository<DisLikes, Integer>  {

    @Query("select dl.subCategory.id from DisLikes dl where dl.profile.id = :profileId")
    List<Integer> findSubcatIdByProfileId(@Param("profileId") String profileId);

    @Query("select dl.category.id from DisLikes dl where dl.profile.id = :profileId")
    List<Integer> findCatIdByProfileId(@Param("profileId") String profileId);

    @Query("select dl from DisLikes dl JOIN dl.category c where dl.profile.id = :profileId and c.id IN :catId")
    List<DisLikes> findDislikesByProfileIdAndCatId(@Param("profileId") String profileId, @Param("catId") List<Integer> catId);

    @Query("select distinct dl.subCategory.id from DisLikes dl JOIN dl.subCategory sc where dl.profile.id = :profileId and sc.id IN :subCatId")
    List<Integer> findDislikesByProfileIdAndSubCatId(@Param("profileId") String profileId, @Param("subCatId") List<Integer> subCatId);

    @Query("select p.id from DisLikes dl JOIN dl.product p where dl.profile.id = :profileId and p.id IN :prodId")
    List<Integer> findDislikesByProfileIdAndProdId(@Param("profileId") String profileId, @Param("prodId") List<Integer> prodId);

    @Modifying
    @Transactional
    @Query("delete from DisLikes dl where dl.profile.id = :profileId and (dl.category.id is not null or dl.subCategory.id is not null)")
    int clearCategorySubCategoryByProfileId(@Param("profileId") String profileId);
}
