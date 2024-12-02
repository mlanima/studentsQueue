package konovalenko.studentsqueue.models;

import jakarta.persistence.Embeddable;

@Embeddable
public record QueueMemberId(Long studentId, Long queueId) {
    public static QueueMemberId of(Long studentId, Long queueId) {
        return new QueueMemberId(studentId, queueId);
    }
}
