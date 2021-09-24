package com.informatica.hackathon.ShareKart.repository;

import com.informatica.hackathon.ShareKart.model.Category;
import com.informatica.hackathon.ShareKart.model.Connection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ConnectionRepository  extends JpaRepository<Connection, Integer> {

    @Query("select c from Connection c where c.from = :profileId or c.to = :profileId")
    List<Connection> findConnectionsForProfile(@Param("profileId") String profileId);

    @Modifying
    @Transactional
    @Query("delete from Connection c where (c.from = :profileId or c.to = :profileId) and (c.from = :connectionId or c.to = :connectionId)")
    void deleteConnectionsForProfile(@Param("profileId") String profileId, @Param("connectionId") String connectionId);
}
