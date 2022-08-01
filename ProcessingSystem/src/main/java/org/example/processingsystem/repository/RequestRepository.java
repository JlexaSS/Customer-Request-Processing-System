package org.example.processingsystem.repository;

import org.example.processingsystem.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, Long> {
}
