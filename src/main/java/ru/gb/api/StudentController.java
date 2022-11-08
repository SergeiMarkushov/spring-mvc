package ru.gb.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.model.Student;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/students")
public class StudentController {
    private final List<Student> students = List.of(
            new Student(1L, "Petya"),
            new Student(2L, "Vanya"),
            new Student(3L, "Vasya"),
            new Student(4L, "Lilya"),
            new Student(5L, "Masha")
    );
    @GetMapping
    public String getStudents(Model model) {
        model.addAttribute("studentList", students);
        return "students";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String getStudent(@PathVariable Long id) {
        Student student = students.stream()
                .filter(it -> Objects.equals(id, it.getId()))
                .findFirst().orElse(null);
        return student.getName();
    }
}
