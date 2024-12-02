package konovalenko.studentsqueue.services;

import konovalenko.studentsqueue.controllers.advice.exceptions.QueueMemberNotFound;
import konovalenko.studentsqueue.models.QueueMemberId;
import konovalenko.studentsqueue.models.Queue;
import konovalenko.studentsqueue.models.QueueMember;
import konovalenko.studentsqueue.models.Student;
import konovalenko.studentsqueue.repos.QueueMemberRepository;
import konovalenko.studentsqueue.repos.QueueRepository;
import konovalenko.studentsqueue.repos.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueueMemberService {

    QueueMemberRepository queueMemberRepository;
    QueueService queueService;
    StudentService studentService;

    @Autowired
    public QueueMemberService(QueueMemberRepository queueMemberRepository, QueueService queueService, StudentService studentService) {
        this.queueMemberRepository = queueMemberRepository;
        this.queueService = queueService;
        this.studentService = studentService;
    }


    public QueueMember addStudentToQueue(Long studentId, Long queueId) {
        Student student = studentService.findStudentById(studentId);
        Queue queue = queueService.findQueueById(queueId);

        QueueMember queueMember = new QueueMember(student, queue);

        return queueMemberRepository.save(queueMember);
    }

    public void deleteStudentFromQueue(Long studentId, Long queueId) {
        QueueMember queueMember = queueMemberRepository.findByQueueMemberId(QueueMemberId.of(studentId, queueId))
                .orElseThrow(QueueMemberNotFound::new);

        queueMemberRepository.delete(queueMember);
    }


}
