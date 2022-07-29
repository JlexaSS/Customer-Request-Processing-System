package org.example.ProcessingSystem.repository;

import org.example.ProcessingSystem.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, Long> {
}
