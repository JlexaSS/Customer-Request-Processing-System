package org.example.processingsystem.services;

import org.example.processingsystem.model.User;
import org.example.processingsystem.repository.UserRepository;
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
class UserServiceTest {
    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    void getAllUser() {
        List<User> userList = new ArrayList<>();
        userList.add(new User((long)1,"Иван", "Иванов", "ivan@ivanov.ru", "pass"));
        userList.add(new User((long)2,"Сергей", "Сергеев", "sergey@sergeev.ru", "password"));
        when(userRepository.findAll()).thenReturn(userList);
        ResponseEntity<List<User>> entity = userService.getAllUser();
        verify(userRepository, times(1)).findAll();
        Assertions.assertTrue(CoreMatchers.is(entity.getStatusCodeValue()).matches(200));
        Assertions.assertEquals(entity.getBody(), userList);
    }
}