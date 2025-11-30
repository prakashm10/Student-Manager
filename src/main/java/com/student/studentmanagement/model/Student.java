package com.student.studentmanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "student_id", unique = true, nullable = true)
    private String studentId;

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    @Column(name = "name")
    private String name;

    @Min(value = 5, message = "Age must be at least 5")
    @Max(value = 100, message = "Age must be less than 100")
    @Column(name = "age", nullable = true)
    private Integer age;

    @Email(message = "Email should be valid")
    @Column(name = "email", nullable = true)
    private String email;

    @Pattern(regexp = "^$|^[0-9]{10}$", message = "Phone number must be 10 digits or empty")
    @Column(name = "phone", nullable = true)
    private String phone;

    @NotBlank(message = "Course is required")
    @Column(name = "course")
    private String course;

    @Column(name = "department", nullable = true)
    private String department;

    @PastOrPresent(message = "Enrollment date cannot be in the future")
    @Column(name = "enrollment_date", nullable = true)
    private LocalDate enrollmentDate;

    @DecimalMin(value = "0.0", message = "GPA must be at least 0.0")
    @DecimalMax(value = "4.0", message = "GPA must be at most 4.0")
    @Column(name = "gpa", nullable = true)
    private Double gpa;

    @Size(max = 255, message = "Address must not exceed 255 characters")
    @Column(name = "address", nullable = true, length = 255)
    private String address;

    @Pattern(regexp = "^$|^(Male|Female|Other)$", message = "Gender must be Male, Female, or Other")
    @Column(name = "gender", nullable = true)
    private String gender;

    // Default constructor
    public Student() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public LocalDate getEnrollmentDate() { return enrollmentDate; }
    public void setEnrollmentDate(LocalDate enrollmentDate) { this.enrollmentDate = enrollmentDate; }

    public Double getGpa() { return gpa; }
    public void setGpa(Double gpa) { this.gpa = gpa; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
}
