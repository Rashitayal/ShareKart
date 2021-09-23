package com.informatica.hackathon.ShareKart.repository;

import com.informatica.hackathon.ShareKart.model.DisLikes;
import com.informatica.hackathon.ShareKart.model.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DisLikesRepository extends JpaRepository<DisLikes, Integer>  {

    @Query("select dl.subCategory.id from DisLikes dl where dl.profile.id = :profileId")
    List<Integer> findSubcatIdByProfileId(@Param("profileId") String profileId);

    @Query("select dl.category.id from DisLikes dl where dl.profile.id = :profileId")
    List<Integer> findCatIdByProfileId(@Param("profileId") String profileId);

}
