package konovalenko.studentsqueue.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.NaturalId;

import java.util.List;

@Entity( name = "queues")
@Table
public class Queue {

    @Id
    @SequenceGenerator(
            name = "queues_sequence",
            sequenceName = "queues_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "queues_sequence"
    )

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long queueId;

    @NaturalId
    @NotNull
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Queue{" +
                "id=" + queueId +
                ", name='" + name + '\'' +
                '}';
    }


    public Long getQueueId() {
        return queueId;
    }

    public void setQueueId(Long id) {
        this.queueId = id;
    }


    @OneToMany( mappedBy = "queue")
    List<QueueMember> queueMembers;

}
