-- Simple SQL script to add missing columns to students table
-- Run this in MySQL: mysql -u root -p student_db < add-columns.sql
-- Or copy and paste these commands into MySQL Workbench or command line

USE student_db;

-- Add new columns (ignore errors if they already exist)
ALTER TABLE students ADD COLUMN student_id VARCHAR(255) NULL;
ALTER TABLE students ADD COLUMN email VARCHAR(255) NULL;
ALTER TABLE students ADD COLUMN phone VARCHAR(20) NULL;
ALTER TABLE students ADD COLUMN department VARCHAR(255) NULL;
ALTER TABLE students ADD COLUMN enrollment_date DATE NULL;
ALTER TABLE students ADD COLUMN gpa DECIMAL(3,2) NULL;
ALTER TABLE students ADD COLUMN address VARCHAR(255) NULL;
ALTER TABLE students ADD COLUMN gender VARCHAR(20) NULL;

-- Add unique constraint on student_id (optional - uncomment if needed)
-- ALTER TABLE students ADD UNIQUE KEY uk_student_id (student_id);




