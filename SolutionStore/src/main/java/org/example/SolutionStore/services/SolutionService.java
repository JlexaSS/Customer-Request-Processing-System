package org.example.SolutionStore.services;

import org.example.SolutionStore.model.Solution;
import org.example.SolutionStore.repository.SolutionRepository;
import org.springframework.stereotype.Service;

@Service
public class SolutionService {
    private final SolutionRepository solutionRepository;

    public SolutionService(SolutionRepository solutionRepository) {
        this.solutionRepository = solutionRepository;
    }

    public String addNewSolution(String type, String typename, String solution){
        if (!solutionRepository.existsByTypeOrTypename(type, typename)){
            solutionRepository.save(new Solution(type, typename, solution));
            return "Решение успешно добавлено";
        } else
            return "Решение с таким типом уже существует!";
    }
}
