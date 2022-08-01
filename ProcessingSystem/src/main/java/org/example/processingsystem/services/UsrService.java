package org.example.processingsystem.services;

import org.example.processingsystem.model.User;
import org.example.processingsystem.repository.UsrRepository;
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
