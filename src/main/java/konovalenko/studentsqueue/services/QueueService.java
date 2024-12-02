package konovalenko.studentsqueue.services;

import konovalenko.studentsqueue.controllers.advice.exceptions.QueueNameAlreadyTakenException;
import konovalenko.studentsqueue.controllers.advice.exceptions.QueueNotFoundException;
import konovalenko.studentsqueue.models.Queue;
import konovalenko.studentsqueue.models.QueueMember;
import konovalenko.studentsqueue.repos.QueueMemberRepository;
import konovalenko.studentsqueue.repos.QueueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QueueService {

    private final QueueRepository queueRepository;
    private final QueueMemberRepository queueMemberRepository;

    @Autowired
    public QueueService(QueueRepository studentsRepository, QueueMemberRepository queueMemberRepository) {
        this.queueRepository = studentsRepository;
        this.queueMemberRepository = queueMemberRepository;
    }

    public List<Queue> getAllQueues() {
        return queueRepository.findAll();
    }

    public Queue addQueue(Queue queue) {

        if (queueRepository.existsByName(queue.getName())) {
            throw new QueueNameAlreadyTakenException();
        }

        return queueRepository.save(queue);
    }

    public void deleteQueue(Long id) {
        if (!queueRepository.existsById(id)) {
            throw new QueueNotFoundException();
        }

        queueRepository.deleteById(id);
    }

    public Queue findQueueById(Long id) {
        return queueRepository.findById(id).orElseThrow(QueueNotFoundException::new);
    }

    @Transactional
    public Queue updateQueue(Long queueId, Queue queue) {
        if (!queueRepository.existsById(queueId)) {
            throw new QueueNotFoundException();
        }

        if( !queueRepository.existsByName(queue.getName() )) {
            throw new QueueNameAlreadyTakenException();
        }

        Queue queueToUpdate = queueRepository.findById(queueId).get();

        if ( queue.getName() != null ) {
            queueToUpdate.setName(queue.getName());
        }

        return queueToUpdate;
    }

    public QueueMember addStudentToQueue(QueueMember queueMember) {
        return this.queueMemberRepository.save(queueMember);
    }
}
