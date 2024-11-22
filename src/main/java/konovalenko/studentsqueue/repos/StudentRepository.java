package konovalenko.studentsqueue.repos;

import konovalenko.studentsqueue.models.Queue;
import konovalenko.studentsqueue.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByStudentId(Long studentId);
}
