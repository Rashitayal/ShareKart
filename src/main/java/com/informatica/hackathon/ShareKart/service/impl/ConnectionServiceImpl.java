package com.informatica.hackathon.ShareKart.service.impl;

import com.informatica.hackathon.ShareKart.model.Connection;
import com.informatica.hackathon.ShareKart.model.Profile;
import com.informatica.hackathon.ShareKart.repository.ConnectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConnectionServiceImpl {

    @Autowired
    ConnectionRepository connectionRepository;

    public List<Profile> getAllConnectionById(String id){
        return connectionRepository.findConnectionsForProfile(id);
    }

    public List<Connection> saveConnection(List<Connection> connection){
        return connectionRepository.saveAll(connection);
    }
}
