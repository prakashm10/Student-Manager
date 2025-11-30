-- Safe migration script - checks if columns exist before adding
-- Run in MySQL Workbench or command line

USE student_db;

-- Function to safely add column (MySQL 8.0+)
-- If column exists, it will show an error but won't break

-- Add student_id
SET @exist := (SELECT COUNT(*) FROM INFORMATION_SCHEMA.COLUMNS 
    WHERE TABLE_SCHEMA = 'student_db' 
    AND TABLE_NAME = 'students' 
    AND COLUMN_NAME = 'student_id');
SET @sqlstmt := IF(@exist = 0, 
    'ALTER TABLE students ADD COLUMN student_id VARCHAR(255) NULL', 
    'SELECT "Column student_id already exists" AS message');
PREPARE stmt FROM @sqlstmt;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;

-- Add email
SET @exist := (SELECT COUNT(*) FROM INFORMATION_SCHEMA.COLUMNS 
    WHERE TABLE_SCHEMA = 'student_db' 
    AND TABLE_NAME = 'students' 
    AND COLUMN_NAME = 'email');
SET @sqlstmt := IF(@exist = 0, 
    'ALTER TABLE students ADD COLUMN email VARCHAR(255) NULL', 
    'SELECT "Column email already exists" AS message');
PREPARE stmt FROM @sqlstmt;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;

-- Add phone
SET @exist := (SELECT COUNT(*) FROM INFORMATION_SCHEMA.COLUMNS 
    WHERE TABLE_SCHEMA = 'student_db' 
    AND TABLE_NAME = 'students' 
    AND COLUMN_NAME = 'phone');
SET @sqlstmt := IF(@exist = 0, 
    'ALTER TABLE students ADD COLUMN phone VARCHAR(20) NULL', 
    'SELECT "Column phone already exists" AS message');
PREPARE stmt FROM @sqlstmt;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;

-- Add department
SET @exist := (SELECT COUNT(*) FROM INFORMATION_SCHEMA.COLUMNS 
    WHERE TABLE_SCHEMA = 'student_db' 
    AND TABLE_NAME = 'students' 
    AND COLUMN_NAME = 'department');
SET @sqlstmt := IF(@exist = 0, 
    'ALTER TABLE students ADD COLUMN department VARCHAR(255) NULL', 
    'SELECT "Column department already exists" AS message');
PREPARE stmt FROM @sqlstmt;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;

-- Add enrollment_date
SET @exist := (SELECT COUNT(*) FROM INFORMATION_SCHEMA.COLUMNS 
    WHERE TABLE_SCHEMA = 'student_db' 
    AND TABLE_NAME = 'students' 
    AND COLUMN_NAME = 'enrollment_date');
SET @sqlstmt := IF(@exist = 0, 
    'ALTER TABLE students ADD COLUMN enrollment_date DATE NULL', 
    'SELECT "Column enrollment_date already exists" AS message');
PREPARE stmt FROM @sqlstmt;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;

-- Add gpa
SET @exist := (SELECT COUNT(*) FROM INFORMATION_SCHEMA.COLUMNS 
    WHERE TABLE_SCHEMA = 'student_db' 
    AND TABLE_NAME = 'students' 
    AND COLUMN_NAME = 'gpa');
SET @sqlstmt := IF(@exist = 0, 
    'ALTER TABLE students ADD COLUMN gpa DECIMAL(3,2) NULL', 
    'SELECT "Column gpa already exists" AS message');
PREPARE stmt FROM @sqlstmt;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;

-- Add address
SET @exist := (SELECT COUNT(*) FROM INFORMATION_SCHEMA.COLUMNS 
    WHERE TABLE_SCHEMA = 'student_db' 
    AND TABLE_NAME = 'students' 
    AND COLUMN_NAME = 'address');
SET @sqlstmt := IF(@exist = 0, 
    'ALTER TABLE students ADD COLUMN address VARCHAR(255) NULL', 
    'SELECT "Column address already exists" AS message');
PREPARE stmt FROM @sqlstmt;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;

-- Add gender
SET @exist := (SELECT COUNT(*) FROM INFORMATION_SCHEMA.COLUMNS 
    WHERE TABLE_SCHEMA = 'student_db' 
    AND TABLE_NAME = 'students' 
    AND COLUMN_NAME = 'gender');
SET @sqlstmt := IF(@exist = 0, 
    'ALTER TABLE students ADD COLUMN gender VARCHAR(20) NULL', 
    'SELECT "Column gender already exists" AS message');
PREPARE stmt FROM @sqlstmt;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;

SELECT 'Migration completed successfully!' AS result;




