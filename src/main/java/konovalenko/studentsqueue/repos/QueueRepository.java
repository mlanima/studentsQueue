package konovalenko.studentsqueue.repos;

import konovalenko.studentsqueue.models.Queue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueueRepository extends JpaRepository<Queue, Long> {
    boolean existsByName(String name);
}
