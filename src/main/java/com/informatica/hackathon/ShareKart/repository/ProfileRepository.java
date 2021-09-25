package com.informatica.hackathon.ShareKart.repository;

import com.informatica.hackathon.ShareKart.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//JpaRepository internally provides @Repository and @Transactional annotations
//String is datatype of id column in profile class
//We have to implement custom Exception i.e. ResourceNotFoundException which will be returned when client is trying to access a resource that does not exist in db.
public interface ProfileRepository extends JpaRepository<Profile, String> {

    @Query("select p from Profile p where p.email = :email")
    Profile findProfileByEmail(@Param("email") String email);

//    select p.profile_id from profile p where p.profile_id not in (select to_id from connections where from_id = "P-5") and p.profile_id !="P-5"
    @Query("select p from Profile p  where p.profileId NOT IN :ids AND p.profileId != :profileId")
    List<Profile> getUnconnectedProfile(@Param("ids") List<String> ids, @Param("profileId") String profileId);

    @Query("select p.gender from Profile p where p.id = :profileId")
    String getGenderForProfile(@Param("profileId") String profileId);

}
