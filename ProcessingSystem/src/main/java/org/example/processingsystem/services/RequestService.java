package org.example.processingsystem.services;

import org.example.processingsystem.model.Request;
import org.example.processingsystem.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RequestService {
    @Value("${solutionstore.api.path}")
    private String api;

    private final RequestRepository requestRepository;

    public RequestService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public ResponseEntity<Map<String,String>> getTypes(){
        HttpHeaders headers = new HttpHeaders();
        Map<String,String> body = new HashMap<>();
        HttpEntity<Map<String,String>> entity= new HttpEntity<>(body, headers);
        return new RestTemplate().exchange(api + "types/", HttpMethod.GET, entity, new ParameterizedTypeReference<>() {});
    }

    public ResponseEntity<String> addNewRequest(Request request){
        if(request == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        requestRepository.save(request);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        return new RestTemplate().exchange(api+"solution/" + request.getType(), HttpMethod.GET, entity, String.class);
    }

    public ResponseEntity<List<Request>> getAllRequest(){
        List<Request> requests = requestRepository.findAll();
        if (requests.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(requests, HttpStatus.OK);
    }

}
