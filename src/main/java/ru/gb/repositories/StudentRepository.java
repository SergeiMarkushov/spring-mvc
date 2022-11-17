package ru.gb.repositories;

import org.springframework.stereotype.Component;
import ru.gb.model.Student;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class StudentRepository {
    private List<Student> students;

    @PostConstruct
    public void init() {
        students = new ArrayList<>(List.of(
                new Student(1L, "Petya", 80),
                new Student(2L, "Vanya", 81),
                new Student(3L, "Vasya", 82),
                new Student(4L, "Lilya", 83),
                new Student(5L, "Masha", 89)
        ));
    }

    public void add(Student s) {
        students.add(s);
    }

    public List<Student> getAllStudents() {
        return Collections.unmodifiableList(students);
    }
//        public Student findByID(Long id) {
//        return students.stream()
//                .filter(student -> student.getId().equals(id))
//                .findFirst()
//                .orElseThrow(() -> new RuntimeException("Student not found"));
//    }

    public void deleteById(Long id) {
        students.removeIf(student -> student.getId().equals(id));
    }

    public Student findByID(Long id) {
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst().get();
    }
}
