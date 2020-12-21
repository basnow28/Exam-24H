package kea.exam.repository;

import kea.exam.model.Supervisor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupervisorRepository extends JpaRepository<Supervisor, Integer> {
}
