package com.student.studentmanagement.repository;

import com.student.studentmanagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrStudentIdContainingIgnoreCase(
        String name, String email, String studentId);
    List<Student> findByDepartmentIgnoreCase(String department);
    List<Student> findByCourseIgnoreCase(String course);
}
