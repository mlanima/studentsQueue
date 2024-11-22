package konovalenko.studentsqueue.controllers;

import jakarta.validation.Valid;
import konovalenko.studentsqueue.controllers.advice.exceptions.IncorrectUserDataException;
import konovalenko.studentsqueue.controllers.advice.ResponseError;
import konovalenko.studentsqueue.models.Queue;
import konovalenko.studentsqueue.models.Student;
import konovalenko.studentsqueue.services.QueueService;
import konovalenko.studentsqueue.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.PutExchange;

import java.util.List;

@RestController
@RequestMapping(path = "students")
public class StudentController{

    final private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    List<Student> getStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping( path = "{studentId}")
    Student findStudent(@PathVariable Long studentId){
        return studentService.findStudentById(studentId);
    }

    @PostMapping(path = "register")
    public Student registerStudent(@RequestBody @Valid Student student){
        return this.studentService.registerStudent(student);
    }


    @PatchMapping(path = "{studentId}")
    public Student updateStudent(@PathVariable Long studentId, @RequestBody Student student){
        return this.studentService.updateStudent(studentId, student);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(  path = "{studentId}")
    public void deleteStudent(@PathVariable Long studentId){
        this.studentService.deleteStudentById(studentId);
    }

    @GetMapping( path = "{studentId}/queues")
    public List<Queue> getQueues(@PathVariable Long studentId){
        return this.studentService.getAllQueuesByStudent(
                this.studentService.findStudentById(studentId)
        );
    }


//    @ExceptionHandler
//    public ResponseError handleException(IncorrectUserDataException exception){
//        return new ResponseError(exception.getMessage(), HttpStatus.BAD_REQUEST);
//    }
}
