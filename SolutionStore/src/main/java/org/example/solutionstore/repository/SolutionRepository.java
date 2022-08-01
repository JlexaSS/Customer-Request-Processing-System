package org.example.solutionstore.repository;

import org.example.solutionstore.model.Solution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SolutionRepository extends JpaRepository<Solution, Long> {
    Boolean existsByTypeOrTypename(String type, String typename);

    @Query("select type, typename from Solution")
    List<String> getTypes();

    @Query("Select solution from Solution where type = ?1")
    String getSolution(String type);
}
