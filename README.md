## Students Queue

Java Spring Boot CRUD Api that allows to create and manage ther queues for students presentating their homework.


### Students Queries

| HTTP-Request | Route | Description |
|--------------|-------|-------------|
| GET | /students | Get all students |
| GET | /students/:studentId | Find a student |
| POST | /students/register | Register a student |
| PATCH | /students/:studentId | Update a student |
| DELETE | /students/:studentId | Get all students |
| GET | /students/:studentId/queues | Get all queues of student |

### Queues queries

| HTTP-Request | Route | Description |
|--------------|-------|-------------|
| GET | /queues | Get all queues |
| GET | /queues/:queueId | Find a queue |
| POST | /queues | Create a queue |
| PATCH | /queue/:queueId | Update a queue name |
| DELETE | /queuess/:queueId | Get all students |
| GET | /queues/:queueId/students | Get all students in queue |

### QueueMember Queries (Compound Stundets+Queues)

| HTTP-Request | Route | Alterantive Route |Description |
|--------------|-------|-------------------|------------|
| POST | /queues/:queueId/students | /students/:studentId/queues/:queueId | Add a student to a queue |
| DELETE | /queues/:queueId/students | /students/:studentId/queues/:queueId | Delete a student from a queue |
