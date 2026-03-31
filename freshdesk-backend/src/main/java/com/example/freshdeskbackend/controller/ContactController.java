package com.example.freshdeskbackend.controller;

import com.example.freshdeskbackend.model.Contact;
import com.example.freshdeskbackend.service.ContactService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
public class ContactController {

    private final ContactService service;

    public ContactController(ContactService service) {
        this.service = service;
    }

    @GetMapping
    public List<Contact> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Contact get(@PathVariable Long id) {
        return service.findById(id).orElseThrow();
    }

    @PostMapping
    public Contact create(@RequestBody Contact c) {
        return service.save(c);
    }

    @PutMapping("/{id}")
    public Contact update(@PathVariable Long id, @RequestBody Contact c) {
        Contact ex = service.findById(id).orElseThrow();
        ex.setName(c.getName());
        ex.setEmail(c.getEmail());
        ex.setPhone(c.getPhone());
        ex.setCompany(c.getCompany());
        return service.save(ex);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/search")
    public List<Contact> search(@RequestParam String q) {
        return service.searchByName(q);
    }
}
