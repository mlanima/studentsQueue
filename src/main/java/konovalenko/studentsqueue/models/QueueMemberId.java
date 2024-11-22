package konovalenko.studentsqueue.models;

import jakarta.persistence.Embeddable;

@Embeddable
public record QueueMemberId(Long studentId, Long queueId) {}
