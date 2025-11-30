-- WARNING: This will DELETE ALL EXISTING STUDENT DATA!
-- Only use this if you don't have important data or have a backup
-- Run this in MySQL

USE student_db;

-- Drop existing table
DROP TABLE IF EXISTS students;

-- Create table with correct structure
CREATE TABLE students (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    course VARCHAR(255) NOT NULL,
    student_id VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    phone VARCHAR(20) NULL,
    department VARCHAR(255) NULL,
    enrollment_date DATE NULL,
    gpa DECIMAL(3,2) NULL,
    address VARCHAR(255) NULL,
    gender VARCHAR(20) NULL,
    UNIQUE KEY uk_student_id (student_id)
);

-- Verify table structure
SHOW COLUMNS FROM students;

SELECT 'Table recreated successfully!' AS result;




