package kea.exam.repository;

import kea.exam.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer>{
    @Modifying
    @Transactional
    @Query(value = "UPDATE students SET student_name = ?1 WHERE student_id = ?2", nativeQuery = true)
    void updateStudentName(String student_name, int student_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE students SET student_email = ?1 WHERE student_id = ?2", nativeQuery = true)
    void updateStudentEmail(String student_email, int student_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE students SET supervisor_supervisor_id = ?1 WHERE student_id = ?2", nativeQuery = true)
    void updateStudentSupervisor(int supervisor_id, int student_id);
}
