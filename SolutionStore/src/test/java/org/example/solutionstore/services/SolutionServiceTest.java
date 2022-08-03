package org.example.solutionstore.services;


import org.example.solutionstore.model.Solution;
import org.example.solutionstore.repository.SolutionRepository;
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
        Solution solution = new Solution("PROBLEM", "Проблема","Выполнить следующие действия");
        Assertions.assertNotNull(solution.getType());
        Assertions.assertNotNull(solution.getTypename());
        Assertions.assertNotNull(solution.getSolution());
        ResponseEntity<Solution> entity = solutionService.saveSolution(solution);
        Assertions.assertTrue(CoreMatchers.is(entity.getStatusCodeValue()).matches(200));
        Mockito.verify(solutionRepository, Mockito.times(1)).save(solution);
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