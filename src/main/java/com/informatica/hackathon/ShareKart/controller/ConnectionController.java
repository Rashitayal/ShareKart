package com.informatica.hackathon.ShareKart.controller;

import com.informatica.hackathon.ShareKart.exception.InputValidator;
import com.informatica.hackathon.ShareKart.exception.InvalidRequestException;
import com.informatica.hackathon.ShareKart.model.Connection;
import com.informatica.hackathon.ShareKart.model.Profile;
import com.informatica.hackathon.ShareKart.service.impl.ConnectionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/connection")
public class ConnectionController {

    @Autowired
    ConnectionServiceImpl connectionService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET,
            consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<Profile>> getConnectionByProfileId(@PathVariable(value = "id") String id) {
        List<Profile> profileList = connectionService.getAllConnectionById(id);
        return new ResponseEntity<>(profileList, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,
            consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<Connection>> saveConnection(@RequestBody List<Connection> connection) throws InvalidRequestException {
        return new ResponseEntity<List<Connection>>(connectionService.saveConnection(connection), HttpStatus.CREATED);
    }

}
