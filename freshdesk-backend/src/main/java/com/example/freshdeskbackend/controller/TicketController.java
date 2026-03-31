package com.example.freshdeskbackend.controller;

import com.example.freshdeskbackend.model.Contact;
import com.example.freshdeskbackend.model.Ticket;
import com.example.freshdeskbackend.service.ContactService;
import com.example.freshdeskbackend.service.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
public class TicketController {

    private final TicketService ticketService;
    private final ContactService contactService;

    public TicketController(TicketService ticketService, ContactService contactService) {
        this.ticketService = ticketService;
        this.contactService = contactService;
    }

    @GetMapping
    public List<Ticket> all() {
        return ticketService.findAll();
    }

    @GetMapping("/{id}")
    public Ticket get(@PathVariable Long id) {
        return ticketService.findById(id).orElseThrow();
    }

    @PostMapping
    public Ticket create(@RequestBody Ticket ticket) {
        if (ticket.getContact() != null && ticket.getContact().getId() != null) {
            Contact c = contactService.findById(ticket.getContact().getId()).orElse(null);
            ticket.setContact(c);
        }
        return ticketService.save(ticket);
    }

    @PutMapping("/{id}")
    public Ticket update(@PathVariable Long id, @RequestBody Ticket ticket) {
        Ticket existing = ticketService.findById(id).orElseThrow();
        existing.setSubject(ticket.getSubject());
        existing.setDescription(ticket.getDescription());
        existing.setStatus(ticket.getStatus());
        existing.setPriority(ticket.getPriority());
        return ticketService.save(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        ticketService.delete(id);
    }

    @GetMapping("/search")
    public List<Ticket> search(@RequestParam String q) {
        List<Ticket> bySub = ticketService.searchBySubject(q);
        List<Ticket> byContact = ticketService.searchByContactName(q);
        bySub.addAll(byContact);
        return bySub;
    }
}
