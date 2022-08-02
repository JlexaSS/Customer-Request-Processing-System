package org.example.processingsystem.controllers;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("api/request/")
public class RestRequestController {
    private final RequestService requestService;

    public RestRequestController(RequestService requestService) {
        this.requestService = requestService;
    }


}
