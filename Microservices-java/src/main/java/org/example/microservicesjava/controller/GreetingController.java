package org.example.microservicesjava.controller;

import jakarta.websocket.server.PathParam;
import org.apache.coyote.Request;
import org.example.microservicesjava.cofings.GreetingConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingConfig greetingConfig;

    public GreetingController(GreetingConfig greetingConfig) {
        this.greetingConfig = greetingConfig;
    }

    @GetMapping()
    public ResponseEntity<String> greeting(@RequestParam(required = false) String nome){

        if(nome==null){
            nome=greetingConfig.getDefaultName();
        }

        return ResponseEntity.ok().body(greetingConfig.getGreeting()+" "+nome);
    }
}
