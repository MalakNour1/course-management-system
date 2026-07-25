package com.innovera.coursemanagementsystem.seed;

import com.innovera.coursemanagementsystem.entity.Course;
import com.innovera.coursemanagementsystem.entity.Enrollment;
import com.innovera.coursemanagementsystem.entity.Instructor;
import com.innovera.coursemanagementsystem.entity.Student;
import com.innovera.coursemanagementsystem.repository.CourseRepository;
import com.innovera.coursemanagementsystem.repository.EnrollmentRepository;
import com.innovera.coursemanagementsystem.repository.InstructorRepository;
import com.innovera.coursemanagementsystem.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class SeedData {

    @Bean
    CommandLineRunner seed(
            InstructorRepository instructorRepository,
            StudentRepository studentRepository,
            CourseRepository courseRepository,
            EnrollmentRepository enrollmentRepository) {

        return args -> {

            // Don't seed twice
            if (courseRepository.count() > 0)
                return;

            // ================= Instructors =================

            Instructor instructor1 = new Instructor();
            instructor1.setName("Dr. Ahmed Hassan");
            instructor1.setEmail("ahmed@innovera.com");

            Instructor instructor2 = new Instructor();
            instructor2.setName("Dr. Sara Mohamed");
            instructor2.setEmail("sara@innovera.com");

            instructorRepository.saveAll(List.of(instructor1, instructor2));

            // ================= Students =================

            Student student1 = new Student();
            student1.setName("Malak Nour");
            student1.setEmail("malak@gmail.com");

            Student student2 = new Student();
            student2.setName("Omar Ali");
            student2.setEmail("omar@gmail.com");

            Student student3 = new Student();
            student3.setName("Mariam Samy");
            student3.setEmail("mariam@gmail.com");

            studentRepository.saveAll(List.of(student1, student2, student3));

            // ================= Courses =================

            Course course1 = new Course();
            course1.setName("Spring Boot");
            course1.setDescription("REST APIs with Spring Boot");
            course1.setCreditHours(3);
            course1.setInstructor(instructor1);
            course1.setRegistrationStartTime(LocalDateTime.now().minusDays(2));
            course1.setRegistrationEndTime(LocalDateTime.now().plusDays(10));
            course1.setDeleted(false);

            Course course2 = new Course();
            course2.setName("Database Systems");
            course2.setDescription("SQL & Database Design");
            course2.setCreditHours(4);
            course2.setInstructor(instructor2);
            course2.setRegistrationStartTime(LocalDateTime.now().minusDays(1));
            course2.setRegistrationEndTime(LocalDateTime.now().plusDays(5));
            course2.setDeleted(false);

            // Registration not started yet
            Course course3 = new Course();
            course3.setName("Software Engineering");
            course3.setDescription("Software Development Lifecycle");
            course3.setCreditHours(3);
            course3.setInstructor(instructor1);
            course3.setRegistrationStartTime(LocalDateTime.now().plusDays(2));
            course3.setRegistrationEndTime(LocalDateTime.now().plusDays(15));
            course3.setDeleted(false);

            // Registration already ended
            Course course4 = new Course();
            course4.setName("Design Patterns");
            course4.setDescription("Creational, Structural & Behavioral Patterns");
            course4.setCreditHours(3);
            course4.setInstructor(instructor2);
            course4.setRegistrationStartTime(LocalDateTime.now().minusDays(10));
            course4.setRegistrationEndTime(LocalDateTime.now().minusDays(2));
            course4.setDeleted(false);

            courseRepository.saveAll(List.of(course1, course2, course3, course4));

            // ================= Enrollments =================

            Enrollment enrollment1 = new Enrollment();
            enrollment1.setStudent(student1);
            enrollment1.setCourse(course1);
            enrollment1.setEnrollmentDate(LocalDate.now());
            enrollment1.setGrade(95.0);

            Enrollment enrollment2 = new Enrollment();
            enrollment2.setStudent(student1);
            enrollment2.setCourse(course2);
            enrollment2.setEnrollmentDate(LocalDate.now());
            enrollment2.setGrade(91.5);

            Enrollment enrollment3 = new Enrollment();
            enrollment3.setStudent(student2);
            enrollment3.setCourse(course2);
            enrollment3.setEnrollmentDate(LocalDate.now());
            enrollment3.setGrade(88.0);

            Enrollment enrollment4 = new Enrollment();
            enrollment4.setStudent(student3);
            enrollment4.setCourse(course1);
            enrollment4.setEnrollmentDate(LocalDate.now());
            enrollment4.setGrade(93.5);

            enrollmentRepository.saveAll(List.of(
                    enrollment1,
                    enrollment2,
                    enrollment3,
                    enrollment4
            ));
        };
    }
}