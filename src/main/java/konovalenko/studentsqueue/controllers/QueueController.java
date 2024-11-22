package konovalenko.studentsqueue.controllers;

import jakarta.validation.Valid;
import konovalenko.studentsqueue.models.Queue;
import konovalenko.studentsqueue.models.QueueMember;
import konovalenko.studentsqueue.models.Student;
import konovalenko.studentsqueue.services.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( path = "queues")
public class QueueController {

    private QueueService queueService;

    @Autowired
    public QueueController( QueueService queueService ) {
        this.queueService = queueService;
    }

    @GetMapping
    public List<Queue> getQueues() {
        return queueService.getAllQueues();
    }

    @PostMapping
    public Queue addQueue( @RequestBody @Valid Queue queue ) {
        return queueService.addQueue(queue);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "{queueId}")
    public void deleteQueue( Long id ) {
        queueService.deleteQueue(id);
    }

    @PatchMapping( path = "{queueId}")
    public Queue updateQueue(@PathVariable Long queueId, @RequestBody Queue queue ) {
        return this.queueService.updateQueue(queueId, queue);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping( path = "{queueId}/students/{studentId}")
    public QueueMember addStudent(@PathVariable Long queueId, @PathVariable Long studentId ) {
        return this.queueService.addStudentToQueue( new QueueMember(queueId, studentId) );
    }


}
