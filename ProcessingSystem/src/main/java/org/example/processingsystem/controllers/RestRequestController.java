package org.example.processingsystem.controllers;

import org.example.processingsystem.model.Request;
import org.example.processingsystem.services.RequestService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("api/request/")
public class RestRequestController {
    private final RequestService requestService;

    public RestRequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @RequestMapping(value = "types/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String,String>> getTypes(){
        return requestService.getTypes();
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addNewRequest(@RequestBody @Valid Request request){
        return requestService.addNewRequest(request);
    }

}
