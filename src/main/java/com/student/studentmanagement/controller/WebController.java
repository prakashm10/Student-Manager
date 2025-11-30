package com.student.studentmanagement.controller;

import com.student.studentmanagement.model.Student;
import com.student.studentmanagement.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class WebController {

    @Autowired
    private StudentService service;

    // Show all students with search and filter
    @GetMapping("/")
    public String home(@RequestParam(required = false) String search,
                       @RequestParam(required = false) String department,
                       @RequestParam(required = false) String course,
                       Model model) {
        List<Student> students = service.getAllStudents();
        
        // Apply search
        if (search != null && !search.trim().isEmpty()) {
            students = service.searchStudents(search);
        }
        
        // Apply department filter
        if (department != null && !department.isEmpty() && !department.equals("All")) {
            students = students.stream()
                    .filter(s -> s.getDepartment().equalsIgnoreCase(department))
                    .collect(Collectors.toList());
        }
        
        // Apply course filter
        if (course != null && !course.isEmpty() && !course.equals("All")) {
            students = students.stream()
                    .filter(s -> s.getCourse().equalsIgnoreCase(course))
                    .collect(Collectors.toList());
        }
        
        // Get unique departments and courses for filter dropdowns
        List<String> departments = service.getAllStudents().stream()
                .map(Student::getDepartment)
                .filter(dept -> dept != null && !dept.isEmpty())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        
        List<String> courses = service.getAllStudents().stream()
                .map(Student::getCourse)
                .filter(c -> c != null && !c.isEmpty())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        
        model.addAttribute("students", students);
        model.addAttribute("departments", departments);
        model.addAttribute("courses", courses);
        model.addAttribute("search", search);
        model.addAttribute("selectedDepartment", department);
        model.addAttribute("selectedCourse", course);
        
        // Statistics
        model.addAttribute("totalStudents", students.size());
        double avgGpa = students.stream()
                .filter(s -> s.getGpa() != null)
                .mapToDouble(Student::getGpa)
                .average()
                .orElse(0.0);
        model.addAttribute("avgGpa", avgGpa);
        
        return "students";
    }

    // Show form to add new student
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("student", new Student());
        return "form";
    }

    // Save student with validation
    @PostMapping("/save")
    public String saveStudent(@ModelAttribute @Valid Student student,
                              BindingResult result,
                              Model model) {
        if (result.hasErrors()) {
            model.addAttribute("student", student);
            return "form";
        }
        service.addStudent(student);
        return "redirect:/";
    }

    // Edit student
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Student existing = service.getStudentById(id);
        if (existing != null) {
            model.addAttribute("student", existing);
            return "form";
        }
        return "redirect:/";
    }

    // View student details
    @GetMapping("/view/{id}")
    public String viewStudent(@PathVariable Long id, Model model) {
        Student student = service.getStudentById(id);
        if (student != null) {
            model.addAttribute("student", student);
            return "student-detail";
        }
        return "redirect:/";
    }

    // Delete student
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteStudent(id);
        return "redirect:/";
    }
}
