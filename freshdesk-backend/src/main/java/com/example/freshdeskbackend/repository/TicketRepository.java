package com.example.freshdeskbackend.repository;

import com.example.freshdeskbackend.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findBySubjectContainingIgnoreCase(String subject);

    @Query("SELECT t FROM Ticket t JOIN t.contact c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :q, '%'))")
    List<Ticket> findByContactName(String q);
}
