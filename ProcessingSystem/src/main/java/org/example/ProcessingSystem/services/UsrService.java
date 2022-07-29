package org.example.ProcessingSystem.services;

import org.example.ProcessingSystem.model.Usr;
import org.example.ProcessingSystem.repository.UsrRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsrService {
    private final UsrRepository usrRepository;

    public UsrService(UsrRepository usrRepository) {
        this.usrRepository = usrRepository;
    }

    public List<Usr> getUsers(){
        return usrRepository.findAll();
    }
}
