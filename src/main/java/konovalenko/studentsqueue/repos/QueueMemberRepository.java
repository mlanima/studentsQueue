package konovalenko.studentsqueue.repos;

import konovalenko.studentsqueue.models.Queue;
import konovalenko.studentsqueue.models.QueueMember;
import konovalenko.studentsqueue.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QueueMemberRepository extends JpaRepository<QueueMember, Long> {
//    List<QueueMember> findByQueueId(Long queueId);
    List<QueueMember> findByStudent(Student student);
}
