package org.example.ProcessingSystem.repository;

import org.example.ProcessingSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsrRepository extends JpaRepository<User, Long> {
}
