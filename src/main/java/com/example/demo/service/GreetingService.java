package com.example.demo.service;

import com.example.demo.model.Greeting;
import com.example.demo.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@Service
public class GreetingService {

    @Autowired
    private GreetingRepository greetingRepository;

   

    public Greeting getGreetingMessage(String type) {
        switch (type.toLowerCase()) {
            case "post":
                return new Greeting(0, "Hello from POST ");
            case "put":
                return new Greeting(0, "Hello from PUT ");
            case "delete":
                return new Greeting(0, "Hello from DELETE ");
            default:
                return new Greeting(0, "Hello from GET ");
        }
    }
}

   