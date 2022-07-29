package org.example.SolutionStore.repository;

import org.example.SolutionStore.model.Solution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolutionRepository extends JpaRepository<Solution, Long> {
    Boolean existsByTypeOrTypename(String type, String typename);
}
