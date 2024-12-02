package konovalenko.studentsqueue.controllers;

import konovalenko.studentsqueue.models.QueueMember;
import konovalenko.studentsqueue.services.QueueMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class QueueMemberController {

    private final QueueMemberService queueMemberService;

    @Autowired
    public QueueMemberController(QueueMemberService queueMemberService) {
        this.queueMemberService = queueMemberService;
    }

    @PostMapping( path = {
            "queue/{queueId}/students/{studentId}",
            "students/{studentId}/queue/{queueId}"
    })
    public QueueMember createQueueMember(@PathVariable Long queueId, @PathVariable Long studentId) {
        return this.queueMemberService.addStudentToQueue(studentId, queueId);
    }

    @DeleteMapping( path = {
            "queue/{queueId}/students/{studentId}",
            "students/{studentId}/queue/{queueId}"
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteQueueMember(@PathVariable Long queueId, @PathVariable Long studentId) {
        this.queueMemberService.deleteStudentFromQueue(studentId, queueId);
    }
}
