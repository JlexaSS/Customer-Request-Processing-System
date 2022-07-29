package org.example.SolutionStore.controllers;

import org.example.SolutionStore.services.SolutionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {
    private final SolutionService solutionService;

    public RequestController(SolutionService solutionService) {
        this.solutionService = solutionService;
    }


    @GetMapping("/gettypes")
    public String getListTypes(){
        return solutionService.getTypes();
    }
}
