package org.example.SolutionStore.controllers;

import org.example.SolutionStore.model.Solution;
import org.example.SolutionStore.services.SolutionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    private final SolutionService solutionService;

    public MainController(SolutionService solutionService) {
        this.solutionService = solutionService;
    }

    @GetMapping
    public String main(){
        return "main";
    }

    @PostMapping
    public String addNewSolution(String type, String typename, String solution, Model model){
        model.addAttribute("message", solutionService.addNewSolution(type, typename, solution));
        return "message";
    }
}
