package org.example.SolutionStore.repository;

import org.example.SolutionStore.model.Solution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SolutionRepository extends JpaRepository<Solution, Long> {
    Boolean existsByTypeOrTypename(String type, String typename);

    @Query("select type, typename from Solution")
    List<String> getTypes();
}
