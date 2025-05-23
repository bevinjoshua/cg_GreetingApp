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
                return new Greeting(0, "Hello from POST (Via Service)");
            case "put":
                return new Greeting(0, "Hello from PUT (Via Service)");
            case "delete":
                return new Greeting(0, "Hello from DELETE (Via Service)");
            default:
                return new Greeting(0, "Hello from GET (Via Service)");
        }
    }
    
    public Greeting getPersonalizedGreeting(String firstName, String lastName) {
        String message;

        if (firstName != null && lastName != null) {
            message = "Hello, " + firstName + " " + lastName + "!";
        } else if (firstName != null) {
            message = "Hello, " + firstName + "!";
        } else if (lastName != null) {
            message = "Hello, Mr/Ms. " + lastName + "!";
        } else {
            message = "Hello World";
        }

        return new Greeting(0, message);
    }
    
    public Greeting save(Greeting greeting) {
        return greetingRepository.save(greeting);
    }
    
    public Greeting findById(long id) {
        return greetingRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Greeting not found"));
    }


    public List<Greeting> findAll() {
        return greetingRepository.findAll();
    }
    
    public Greeting update(long id, Greeting greeting) {
        if (!greetingRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Greeting not found");
        }
        greeting.setId(id);
        return greetingRepository.save(greeting);
    }

}

   