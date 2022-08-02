package org.example.processingsystem.repository;

import org.example.processingsystem.enums.StatusEnums;
import org.example.processingsystem.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface RequestRepository extends JpaRepository<Request, Long> {
    @Modifying
    @Transactional
    @Query("update Request SET status=?1 where id=?2")
    int updateStatus(StatusEnums status, Long requestId);
}
