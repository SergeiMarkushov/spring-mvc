package ru.gb.serveces;

import org.springframework.stereotype.Service;
import ru.gb.model.Student;
import ru.gb.repositories.StudentRepository;

import java.util.List;

@Service
public class StudentService {

    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    public void changeScore(Long studentId, Integer delta) {
        Student student = studentRepository.findByID(studentId);
        student.setScore(student.getScore() + delta);
    }
}
