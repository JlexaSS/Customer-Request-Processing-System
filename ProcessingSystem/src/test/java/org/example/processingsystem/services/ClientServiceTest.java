package org.example.processingsystem.services;

import org.example.processingsystem.model.Client;
import org.example.processingsystem.repository.ClientRepository;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ClientServiceTest {
    @Autowired
    private ClientService clientService;

    @MockBean
    private ClientRepository clientRepository;

    @Test
    void getAllClient() {
        List<Client> clientList = new ArrayList<>();
        clientList.add(new Client((long)1,"Иван", "Иванов"));
        clientList.add(new Client((long)2,"Сергей", "Сергеев"));
        when(clientRepository.findAll()).thenReturn(clientList);
        ResponseEntity<List<Client>> entity = clientService.getAllClient();
        verify(clientRepository, times(1)).findAll();
        Assertions.assertTrue(CoreMatchers.is(entity.getStatusCodeValue()).matches(200));
        Assertions.assertEquals(entity.getBody(), clientList);
    }
}