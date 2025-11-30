-- Add the missing id column as primary key
-- This is the fix for "Unknown column 's1_0.id'" error

USE student_db;

-- Add id column as AUTO_INCREMENT PRIMARY KEY
ALTER TABLE students ADD COLUMN id BIGINT AUTO_INCREMENT PRIMARY KEY FIRST;

-- Verify the table structure
SHOW COLUMNS FROM students;

SELECT 'ID column added successfully!' AS result;




