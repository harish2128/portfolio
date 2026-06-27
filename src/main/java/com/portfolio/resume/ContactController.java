package com.portfolio.resume;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    @Autowired
    private ContactMessageRepository repository;

    @PostMapping
    public ResponseEntity<String> submitContactForm(@RequestBody ContactMessage message) {
        try {
            repository.save(message);
            return ResponseEntity.ok("Message received successfully!");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Failed to process message.");
        }
    }
}
