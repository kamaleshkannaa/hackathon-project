package com.example.freshdeskbackend.service;

import com.example.freshdeskbackend.model.Contact;
import com.example.freshdeskbackend.repository.ContactRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    private final ContactRepository repo;

    public ContactService(ContactRepository repo) {
        this.repo = repo;
    }

    public Contact save(Contact c) { return repo.save(c); }

    public List<Contact> findAll() { return repo.findAll(); }

    public Optional<Contact> findById(Long id) { return repo.findById(id); }

    public void delete(Long id) { repo.deleteById(id); }

    public List<Contact> searchByName(String q) { return repo.findByNameContainingIgnoreCase(q); }
}
