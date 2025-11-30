-- Complete script to check and fix students table structure
-- Run this in MySQL

USE student_db;

-- First, let's check what columns exist
SHOW COLUMNS FROM students;

-- If the table structure is wrong, you can drop and recreate it
-- WARNING: This will delete all existing data!
-- Uncomment the next lines only if you want to recreate the table:

/*
DROP TABLE IF EXISTS students;

CREATE TABLE students (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    course VARCHAR(255) NOT NULL,
    student_id VARCHAR(255) NULL UNIQUE,
    email VARCHAR(255) NULL,
    phone VARCHAR(20) NULL,
    department VARCHAR(255) NULL,
    enrollment_date DATE NULL,
    gpa DECIMAL(3,2) NULL,
    address VARCHAR(255) NULL,
    gender VARCHAR(20) NULL
);
*/

-- OR, if you want to keep existing data, try to fix the structure:
-- Make sure id column exists and is primary key
ALTER TABLE students MODIFY COLUMN id BIGINT AUTO_INCREMENT PRIMARY KEY;

-- Then add missing columns (if they don't exist)
-- These will error if columns already exist, but that's okay

ALTER TABLE students ADD COLUMN IF NOT EXISTS student_id VARCHAR(255) NULL;
ALTER TABLE students ADD COLUMN IF NOT EXISTS email VARCHAR(255) NULL;
ALTER TABLE students ADD COLUMN IF NOT EXISTS phone VARCHAR(20) NULL;
ALTER TABLE students ADD COLUMN IF NOT EXISTS department VARCHAR(255) NULL;
ALTER TABLE students ADD COLUMN IF NOT EXISTS enrollment_date DATE NULL;
ALTER TABLE students ADD COLUMN IF NOT EXISTS gpa DECIMAL(3,2) NULL;
ALTER TABLE students ADD COLUMN IF NOT EXISTS address VARCHAR(255) NULL;
ALTER TABLE students ADD COLUMN IF NOT EXISTS gender VARCHAR(20) NULL;

-- Show final table structure
SHOW COLUMNS FROM students;




