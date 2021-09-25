package com.informatica.hackathon.ShareKart.repository;

import com.informatica.hackathon.ShareKart.model.Connection;
import com.informatica.hackathon.ShareKart.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface ConnectionRepository  extends JpaRepository<Connection, Integer> {

    @Query("select c.to from Connection c where c.from.id = :profileId")
    List<Profile> findConnectionsForProfile(@Param("profileId") String profileId);

    @Query("select c.to.id from Connection c where c.from.id = :profileId")
    List<String> findConnectionsIdsForProfile(@Param("profileId") String profileId);

}
