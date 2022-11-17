package ru.gb.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.model.Student;
import ru.gb.serveces.StudentService;

import java.util.List;

@RestController
public class StudentController {

   private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/students/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        studentService.deleteById(id);
    }

    @GetMapping("/students/change_score")
    public void changeScore(@RequestParam Long studentId, @RequestParam Integer delta) {
        studentService.changeScore(studentId, delta);
    }
}
