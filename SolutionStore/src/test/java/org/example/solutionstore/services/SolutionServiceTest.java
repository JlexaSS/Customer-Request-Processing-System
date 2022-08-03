package org.example.solutionstore.services;


import org.example.solutionstore.repository.SolutionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class SolutionServiceTest {
    @Autowired
    private SolutionService solutionService;

    @MockBean
    private SolutionRepository solutionRepository;

    @Test
    void getSolution() {
    }

    @Test
    void getAllSolution() {
    }

    @Test
    void deleteSolution() {
    }

    @Test
    void saveSolution() {
    }

    @Test
    void updateSolution() {
    }

    @Test
    void getTypes() {
    }

    @Test
    void getClientSolution() {
    }
}