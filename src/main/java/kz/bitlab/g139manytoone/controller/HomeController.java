package kz.bitlab.g139manytoone.controller;

import kz.bitlab.g139manytoone.entity.City;
import kz.bitlab.g139manytoone.entity.Student;
import kz.bitlab.g139manytoone.service.CityService;
import kz.bitlab.g139manytoone.service.StudentService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final StudentService studentService;
    private final CityService cityService;

    @GetMapping("/")
    public String home(Model model) {
        List<Student> students = studentService.getStudents();
        List<City> cities = cityService.getCities();
        model.addAttribute("students", students);
        model.addAttribute("cities", cities);
        return "home";
    }

    @PostMapping("/students/add")
    public String addStudent(Student student) {
        studentService.addStudent(student);
        return "redirect:/";
    }

    @GetMapping("/students/{id}")
    public String studentDetails(@PathVariable Long id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        List<City> cities = cityService.getCities();
        model.addAttribute("cities", cities);
        return "student-details";
    }
}
