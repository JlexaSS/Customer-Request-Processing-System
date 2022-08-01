package org.example.ProcessingSystem.services;

import org.example.ProcessingSystem.model.User;
import org.example.ProcessingSystem.repository.UsrRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsrService {
    private final UsrRepository usrRepository;

    public UsrService(UsrRepository usrRepository) {
        this.usrRepository = usrRepository;
    }

    public List<User> getUsers(){
        return usrRepository.findAll();
    }
}
