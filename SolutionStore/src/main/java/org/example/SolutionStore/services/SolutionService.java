package org.example.SolutionStore.services;

import com.google.gson.Gson;
import org.example.SolutionStore.model.Solution;
import org.example.SolutionStore.repository.SolutionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public String getTypes(){
        Map<String, String> types = solutionRepository.getTypes().stream().collect(Collectors.toMap(x -> x.split(",")[0], x -> x.split(",")[1]));
        return new Gson().toJson(types);
    }
}
