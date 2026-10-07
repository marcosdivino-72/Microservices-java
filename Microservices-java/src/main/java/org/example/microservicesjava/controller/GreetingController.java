package org.example.microservicesjava.controller;

import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @GetMapping("/{nome}")
    public ResponseEntity<String> greeting(@PathVariable String nome){


        return ResponseEntity.ok().body("Hello "+nome);
    }
}
