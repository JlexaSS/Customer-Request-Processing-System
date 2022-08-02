package org.example.solutionstore.controllers;

import org.example.solutionstore.model.Solution;
import org.example.solutionstore.services.SolutionService;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/solutions/")
public class SolutionRestController {
    private final SolutionService solutionService;

    public SolutionRestController(SolutionService solutionService) {
        this.solutionService = solutionService;
    }

}
