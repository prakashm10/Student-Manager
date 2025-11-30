package com.student.studentmanagement.service;

import com.student.studentmanagement.model.Student;
import com.student.studentmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public Student addStudent(Student student) {
        return repo.save(student);
    }

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public Student getStudentById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        Student student = repo.findById(id).orElse(null);
        if (student != null) {
            student.setStudentId(updatedStudent.getStudentId());
            student.setName(updatedStudent.getName());
            student.setAge(updatedStudent.getAge());
            student.setEmail(updatedStudent.getEmail());
            student.setPhone(updatedStudent.getPhone());
            student.setCourse(updatedStudent.getCourse());
            student.setDepartment(updatedStudent.getDepartment());
            student.setEnrollmentDate(updatedStudent.getEnrollmentDate());
            student.setGpa(updatedStudent.getGpa());
            student.setAddress(updatedStudent.getAddress());
            student.setGender(updatedStudent.getGender());
            return repo.save(student);
        }
        return null;
    }
    
    public List<Student> searchStudents(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return getAllStudents();
        }
        return repo.findByNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrStudentIdContainingIgnoreCase(
            keyword, keyword, keyword);
    }
    
    public List<Student> filterByDepartment(String department) {
        if (department == null || department.trim().isEmpty() || department.equals("All")) {
            return getAllStudents();
        }
        return repo.findByDepartmentIgnoreCase(department);
    }
    
    public List<Student> filterByCourse(String course) {
        if (course == null || course.trim().isEmpty() || course.equals("All")) {
            return getAllStudents();
        }
        return repo.findByCourseIgnoreCase(course);
    }

    public boolean deleteStudent(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}
