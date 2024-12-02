package konovalenko.studentsqueue.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;


@Entity( name = "queue_members")
//@Table( uniqueConstraints = {
//        @UniqueConstraint(
//                name = "unique_member_queue_number",
//                columnNames = {"studentId", "queueId", "queueNumber"}
//        )
//} )
@Table( name = "queue_members", uniqueConstraints = {
        @UniqueConstraint( columnNames = {"student_id", "queue_id", "joined"} )
} )
public class QueueMember {

    @EmbeddedId
    QueueMemberId queueMemberId;


    @ManyToOne
    @MapsId("studentId") // Maps the studentId attribute of embedded id
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @MapsId("queueId") // Maps the queueId attribute of embedded id
    @JoinColumn(name = "queue_id")
    private Queue queue;

    @Column( nullable = false, name = "joined")
    private LocalDateTime joined;

    public QueueMember(Long studentId, Long queueId) {
        this(new QueueMemberId(studentId, queueId)) ;
    }

    public QueueMemberId getQueueMemberId() {
        return queueMemberId;
    }

    public void setQueueMemberId(QueueMemberId queueMemberId) {
        this.queueMemberId = queueMemberId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Queue getQueue() {
        return queue;
    }

    public void setQueue(Queue queue) {
        this.queue = queue;
    }

    public LocalDateTime getJoined() {
        return joined;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QueueMember that)) return false;
        return Objects.equals(student, that.student) && Objects.equals(queue, that.queue) && Objects.equals(joined, that.joined);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student, queue, joined);
    }

    public void setJoined(LocalDateTime joined) {
        this.joined = joined;
    }

    public QueueMember() {}

    public QueueMember(QueueMemberId queueMemberId) {
        this.queueMemberId = queueMemberId;
        this.joined = LocalDateTime.now();
    }

    public QueueMember(Student student, Queue queue) {
        this(student.getStudentId(), queue.getQueueId());
        this.student = student;
        this.queue = queue;
    }
}

