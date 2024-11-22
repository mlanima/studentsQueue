package konovalenko.studentsqueue.services;

import konovalenko.studentsqueue.controllers.advice.exceptions.EmailAlreadyTakenException;
import konovalenko.studentsqueue.controllers.advice.exceptions.StudentAlreadyExistException;
import konovalenko.studentsqueue.controllers.advice.exceptions.StudentNotFoundException;
import konovalenko.studentsqueue.models.Queue;
import konovalenko.studentsqueue.models.QueueMember;
import konovalenko.studentsqueue.models.Student;
import konovalenko.studentsqueue.repos.QueueMemberRepository;
import konovalenko.studentsqueue.repos.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentsRepository;
    private final QueueMemberRepository queueMemberRepository;

    @Autowired
    public StudentService(StudentRepository studentsRepository, QueueMemberRepository queueMemberRepository) {
        this.studentsRepository = studentsRepository;
        this.queueMemberRepository = queueMemberRepository;
    }

    public List<Student> getAllStudents() {
        return studentsRepository.findAll();
    }

    public Student registerStudent(Student student) {

        if (studentsRepository.existsByStudentId(student.getStudentId())) {
            throw new StudentAlreadyExistException(student.getStudentId());
        }

        if (studentsRepository.findByEmail(student.getEmail()).isPresent()) {
            throw new EmailAlreadyTakenException();
        }

        return studentsRepository.save(student);
    }

    public Student findStudentById(Long studentId) {
        return studentsRepository.findById(studentId).orElseThrow(StudentNotFoundException::new);
    }

    @Transactional
    public Student updateStudent(Long studentId, Student student) {
        Student studentToUpdate = findStudentById(studentId);

        if (student.getName() != null) {
            studentToUpdate.setName(student.getName());
        }

        if (student.getEmail() != null) {
            studentsRepository.findByEmail(student.getEmail())
                    .ifPresent( student1 -> {throw new EmailAlreadyTakenException();} );
            studentToUpdate.setEmail(student.getEmail());
        }

        if (student.getSurname() != null) {
            studentToUpdate.setSurname(student.getSurname());
        }

        return studentToUpdate;
    }

    public ResponseEntity<HttpStatus> deleteStudentById(Long studentId) {

        if (!studentsRepository.existsById(studentId)) {
            throw new StudentNotFoundException();
        }

        this.studentsRepository.deleteById(studentId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    public List<Queue> getAllQueuesByStudent(Student student) {
        return this.queueMemberRepository.findByStudent(student).stream()
                .map(QueueMember::getQueue)
                .toList();
    }
}
