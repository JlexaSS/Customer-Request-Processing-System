package org.example.ProcessingSystem.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.ProcessingSystem.model.Client;
import org.example.ProcessingSystem.model.Request;
import org.example.ProcessingSystem.model.Usr;
import org.example.ProcessingSystem.repository.RequestRepository;
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

    public String addNewRequest(Client client, Usr user, String type) throws IOException {
        requestRepository.save(new Request(client, user, type));
        URL url = new URL("http://localhost:9000/getsolution?type=" + type);
        String res = new ObjectMapper().readValue(url, new TypeReference<String>() {});
        return res;
    }
}
