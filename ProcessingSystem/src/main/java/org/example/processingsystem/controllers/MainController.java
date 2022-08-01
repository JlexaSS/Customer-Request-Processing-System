package org.example.processingsystem.controllers;

import org.example.processingsystem.model.Client;
import org.example.processingsystem.model.User;
import org.example.processingsystem.services.ClientService;
import org.example.processingsystem.services.RequestService;
import org.example.processingsystem.services.UsrService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
public class MainController {
    private final RequestService requestService;
    private final UsrService usrService;
    private final ClientService clientService;

    public MainController(RequestService requestService, UsrService usrService, ClientService clientService) {
        this.requestService = requestService;
        this.usrService = usrService;
        this.clientService = clientService;
    }

    @GetMapping
    public String main(Model model) throws IOException {
        model.addAttribute("types", requestService.getTypes());
        model.addAttribute("users", usrService.getUsers());
        model.addAttribute("clients", clientService.getClients());
        return "main";
    }

    @PostMapping
    public String addNewRequest(Client client, User user, String type, Model model) throws IOException {
        model.addAttribute("solution", requestService.addNewRequest(client, user, type));
        return "solution";
    }
}
