package org.example.processingsystem.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.processingsystem.model.Client;
import org.example.processingsystem.model.Request;
import org.example.processingsystem.model.User;
import org.example.processingsystem.repository.RequestRepository;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

@Service
public class RequestService {
    private final RequestRepository requestRepository;

    public RequestService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public Map<String, String> getTypes() throws IOException {
        URL url = new URL("http://localhost:9000/gettypes");
        return new ObjectMapper().readValue(url, new TypeReference<Map<String, String>>() {});
    }

    public ResponseEntity<String> addNewRequest(Request request){
        if(request == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        requestRepository.save(request);
        HttpHeaders headers = new HttpHeaders();
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        return restTemplate.exchange("http://localhost:9000/api/solutions/solution/" + request.getType(), HttpMethod.GET, entity, String.class);
    }

}
