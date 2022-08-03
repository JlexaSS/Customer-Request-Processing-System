package org.example.solutionstore.services;


import org.apache.el.parser.AstSetData;
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

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class SolutionServiceTest {
    @Autowired
    private SolutionService solutionService;

    @MockBean
    private SolutionRepository solutionRepository;

    @Test
    void getSolution() {
        Solution solution = new Solution((long)1,"TEST", "Проблема","Выполнить следующие действия");
        when(solutionRepository.findById((long)1)).thenReturn(java.util.Optional.of(solution));
        ResponseEntity<Solution> entity = solutionService.getSolution((long)1);
        verify(solutionRepository, times(1)).findById((long)1);
        Assertions.assertTrue(CoreMatchers.is(entity.getStatusCodeValue()).matches(200));
        Assertions.assertEquals(entity.getBody(), solution);
    }

    @Test
    void getAllSolution() {
        List<Solution> solutionList = new ArrayList<>();
        solutionList.add(new Solution((long)1,"TEST", "Проблема","Выполнить следующие действия"));
        solutionList.add(new Solution((long)2,"ERROR", "Ошибка","Следуйте указаниям"));
        when(solutionRepository.findAll()).thenReturn(solutionList);
        ResponseEntity<List<Solution>> entity = solutionService.getAllSolution();
        verify(solutionRepository, times(1)).findAll();
        Assertions.assertTrue(CoreMatchers.is(entity.getStatusCodeValue()).matches(200));
        Assertions.assertEquals(entity.getBody(), solutionList);
    }

    @Test
    void deleteSolution() {
        Solution solution = new Solution((long)1,"TEST", "Проблема","Выполнить следующие действия");
        when(solutionRepository.findById((long)1)).thenReturn(java.util.Optional.of(solution));
        ResponseEntity<Solution> entity = solutionService.deleteSolution((long)1);
        verify(solutionRepository, times(1)).delete(solution);
        Assertions.assertTrue(CoreMatchers.is(entity.getStatusCodeValue()).matches(204));
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