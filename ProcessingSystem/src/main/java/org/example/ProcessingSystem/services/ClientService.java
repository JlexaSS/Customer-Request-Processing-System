package org.example.ProcessingSystem.services;

import org.example.ProcessingSystem.model.Client;
import org.example.ProcessingSystem.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getClients(){
        return clientRepository.findAll();
    }
}
