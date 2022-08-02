package org.example.solutionstore.services;

import org.example.solutionstore.model.Solution;
import org.example.solutionstore.repository.SolutionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SolutionService {
    private final SolutionRepository solutionRepository;

    public SolutionService(SolutionRepository solutionRepository) {
        this.solutionRepository = solutionRepository;
    }

    public ResponseEntity<Solution> deleteSolution(Long solutionId) {
        Optional<Solution> solutionOptional = solutionRepository.findById(solutionId);
        if (solutionOptional.isPresent()) {
            solutionRepository.delete(solutionOptional.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    }

    public ResponseEntity<Solution> updateSolution(Solution solution) {
        if (solution == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        solutionRepository.save(solution);
        return new ResponseEntity<>(solution, HttpStatus.OK);
    }

    public ResponseEntity<Map<String, String>> getTypes() {
        Map<String, String> types = solutionRepository.getTypes().stream().collect(Collectors.toMap(x -> x.split(",")[0], x -> x.split(",")[1]));
        if (types.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(types, HttpStatus.OK);
    }

    }
}
