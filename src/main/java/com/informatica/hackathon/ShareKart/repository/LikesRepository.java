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

}
