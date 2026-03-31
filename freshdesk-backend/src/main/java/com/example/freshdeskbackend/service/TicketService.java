package com.example.freshdeskbackend.service;

import com.example.freshdeskbackend.model.Ticket;
import com.example.freshdeskbackend.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    private final TicketRepository repo;

    public TicketService(TicketRepository repo) {
        this.repo = repo;
    }

    public Ticket save(Ticket ticket) {
        ticket.setUpdatedAt(Instant.now());
        return repo.save(ticket);
    }

    public List<Ticket> findAll() {
        return repo.findAll();
    }

    public Optional<Ticket> findById(Long id) {
        return repo.findById(id);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    // Search by subject
    public List<Ticket> searchBySubject(String q) {
        return repo.findBySubjectContainingIgnoreCase(q);
    }

    // Search by contact name
    public List<Ticket> searchByContactName(String q) {
        return repo.findByContactName(q);
    }
}
