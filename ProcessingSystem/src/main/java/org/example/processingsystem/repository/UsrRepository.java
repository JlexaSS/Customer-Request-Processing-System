package org.example.processingsystem.repository;

import org.example.processingsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsrRepository extends JpaRepository<User, Long> {
}
