package org.example.solutionstore.services;

import org.example.solutionstore.model.Solution;
import org.example.solutionstore.repository.SolutionRepository;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SolutionService {
    private final SolutionRepository solutionRepository;

    public SolutionService(SolutionRepository solutionRepository) {
        this.solutionRepository = solutionRepository;
    }

        } else
    }

        Map<String, String> types = solutionRepository.getTypes().stream().collect(Collectors.toMap(x -> x.split(",")[0], x -> x.split(",")[1]));
    }

    }
}
