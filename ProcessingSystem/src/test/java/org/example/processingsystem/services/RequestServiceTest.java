package org.example.processingsystem.services;

import org.example.processingsystem.enums.StatusEnums;
import org.example.processingsystem.model.Client;
import org.example.processingsystem.model.Request;
import org.example.processingsystem.model.User;
import org.example.processingsystem.repository.RequestRepository;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
    void addNewRequest(){
        User user = new User((long)1,"Иван", "Иванов", "ivan@ivanov.ru", "pass");
        Client client = new Client((long)1,"Иван", "Иванов");
        Request request = new Request((long)1, client, user, "TEST", LocalDateTime.now(), StatusEnums.PROCESS);
        ResponseEntity entity = requestService.addNewRequest(request);
        Mockito.verify(requestRepository, Mockito.times(1)).save(request);
        Assertions.assertTrue(CoreMatchers.is(entity.getStatusCodeValue()).matches(200));
    }

    @Test
    void getAllRequest() {
        User user1 = new User((long)1,"Иван", "Иванов", "ivan@ivanov.ru", "pass");
        User user2 = new User((long)2,"Сергей", "Сергеев", "sergey@sergeev.ru", "password");
        Client client1 =new Client((long)1,"Иван", "Иванов");
        Client client2 =new Client((long)2,"Сергей", "Сергеев");
        List<Request> requestList = new ArrayList<>();
        requestList.add(new Request((long)1, client1, user1, "PROBLEM", LocalDateTime.now(), StatusEnums.PROCESS));
        requestList.add(new Request((long)2, client2, user2, "TEST", LocalDateTime.now(), StatusEnums.PROCESSED));
        when(requestRepository.findAll()).thenReturn(requestList);
        ResponseEntity<List<Request>> entity = requestService.getAllRequest();
        verify(requestRepository, times(1)).findAll();
        Assertions.assertTrue(CoreMatchers.is(entity.getStatusCodeValue()).matches(200));
        Assertions.assertEquals(entity.getBody(), requestList);
    }

    @Test
    void changeStatus() {
        StatusEnums statusEnums = StatusEnums.PROCESS;
        String status = "PROCESS";
        when(requestRepository.updateStatus(statusEnums,(long)1)).thenReturn(1);
        ResponseEntity<String> entity = requestService.changeStatus((long) 1, status);
        verify(requestRepository, times(1)).updateStatus(statusEnums, (long) 1);
        Assertions.assertTrue(CoreMatchers.is(entity.getStatusCodeValue()).matches(200));
    }
}