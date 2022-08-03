package org.example.processingsystem.services;

import org.example.processingsystem.repository.RequestRepository;
import org.example.processingsystem.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class RequestServiceTest {
    @Autowired
    private RequestService requestService;

    @MockBean
    private RequestRepository requestRepository;

    @Test
    void getTypes() {
    }

    @Test
    void addNewRequest() {
    }

    @Test
    void getAllRequest() {
    }

    @Test
    void changeStatus() {
    }
}