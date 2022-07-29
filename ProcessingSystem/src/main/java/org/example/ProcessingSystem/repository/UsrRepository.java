package org.example.ProcessingSystem.repository;

import org.example.ProcessingSystem.model.Usr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsrRepository extends JpaRepository<Usr, Long> {
}
