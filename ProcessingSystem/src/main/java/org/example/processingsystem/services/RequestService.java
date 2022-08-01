package org.example.processingsystem.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.processingsystem.model.Client;
import org.example.processingsystem.model.Request;
import org.example.processingsystem.model.User;
import org.example.processingsystem.repository.RequestRepository;
import org.springframework.stereotype.Service;

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

    public String addNewRequest(Client client, User user, String type) throws IOException {
        requestRepository.save(new Request(client, user, type));
        URL url = new URL("http://localhost:9000/getsolution?type=" + type);
        String res = new ObjectMapper().readValue(url, new TypeReference<String>() {});
        return res;
    }
}
