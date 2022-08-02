package org.example.solutionstore.controllers;

import org.example.solutionstore.model.Solution;
import org.example.solutionstore.services.SolutionService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/solutions/")
public class SolutionRestController {
    private final SolutionService solutionService;

    public SolutionRestController(SolutionService solutionService) {
        this.solutionService = solutionService;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Solution> getSolution(@PathVariable("id") Long solutionId) {
        return solutionService.getSolution(solutionId);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Solution>> getAllSolution() {
        return solutionService.getAllSolution();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Solution> deleteSolution(@PathVariable("id") Long solutionId) {
        return solutionService.deleteSolution(solutionId);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Solution> saveSolution(@RequestBody Solution solution) {
        return solutionService.saveSolution(solution);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Solution> updateSolution(@RequestBody Solution solution) {
        return solutionService.updateSolution(solution);
    }

    @RequestMapping(value = "/types", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> getTypes() {
        return solutionService.getTypes();
    }
}
