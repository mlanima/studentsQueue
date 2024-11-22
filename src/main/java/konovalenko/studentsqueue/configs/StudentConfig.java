package konovalenko.studentsqueue.configs;

import konovalenko.studentsqueue.models.Student;
import konovalenko.studentsqueue.repos.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentsRepository) {
        return args -> {
            Student testStudent = new Student(
                    65654030L,
                    "Danylo",
                    "Konovalenko",
                    "danylo.konovalenko@mni.thm.de");

            studentsRepository.save(testStudent);
        };
    }

}
