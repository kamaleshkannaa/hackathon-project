package com.example.freshdeskbackend.repository;

import com.example.freshdeskbackend.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findByNameContainingIgnoreCase(String name);
}
