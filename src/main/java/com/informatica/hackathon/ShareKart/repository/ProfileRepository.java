package com.informatica.hackathon.ShareKart.repository;

import com.informatica.hackathon.ShareKart.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

//JpaRepository internally provides @Repository and @Transactional annotations
//String is datatype of id column in profile class
//We have to implement custom Exception i.e. ResourceNotFoundException which will be returned when client is trying to access a resource that does not exist in db.
public interface ProfileRepository extends JpaRepository<Profile, String>{

    @Query("select p from Profile p where p.email = :email")
    Profile findProfileByEmail(@Param("email") String email);

}
