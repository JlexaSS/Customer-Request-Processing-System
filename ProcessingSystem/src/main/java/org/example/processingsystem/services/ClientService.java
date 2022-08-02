package org.example.processingsystem.services;

import org.example.processingsystem.model.Client;
import org.example.processingsystem.repository.ClientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ResponseEntity<List<Client>> getAllClient(){
        List<Client> clients = clientRepository.findAll();
        if(clients.isEmpty())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }
}
