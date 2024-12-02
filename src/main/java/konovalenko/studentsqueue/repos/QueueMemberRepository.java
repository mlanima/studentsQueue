package konovalenko.studentsqueue.repos;

import konovalenko.studentsqueue.models.Queue;
import konovalenko.studentsqueue.models.QueueMember;
import konovalenko.studentsqueue.models.QueueMemberId;
import konovalenko.studentsqueue.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface QueueMemberRepository extends JpaRepository<QueueMember, Long> {

    List<QueueMember> findByStudent_StudentId(Long studentId);
    List<QueueMember> findByStudent(Student student);

    Optional<QueueMember> findByQueueMemberId(QueueMemberId queueMemberId);
}
