# Student Performance Management System

## Project Overview

The Student Performance Management System is a Java-based command-line application developed to manage student academic information.

The system allows users to add and manage student details, marks, attendance, and overall performance. It also calculates percentages and grades and generates a performance report for individual students.

The project uses basic Java and Object-Oriented Programming concepts along with file handling to store data.

## Objectives

- Manage student information.
- Store and manage student marks.
- Record and calculate attendance.
- Calculate total marks, percentage, and grade.
- Analyze the overall performance of students.
- Generate student performance reports.
- Validate user input.
- Store data in files for future use.

## Features

### Student Management

The system provides options to:

- Add a student
- View all students
- Search for a student
- Update student details
- Delete a student

### Marks Management

Users can:

- Add marks for Mathematics, Java, and Operating Systems
- View all marks
- Search marks using Student ID
- Calculate total marks
- Calculate percentage
- Calculate the student's grade

### Attendance Management

The system can:

- Add attendance records
- View attendance records
- Search attendance using Student ID
- Calculate attendance percentage
- Check whether the student meets the 75% attendance requirement

### Performance Analysis

The system considers both marks and attendance to determine the student's overall performance.

The performance is classified as:

- Excellent
- Good
- Average
- Needs Improvement

The system also displays warnings when the student's marks or attendance are below the required level.

### Student Report

A complete report can be generated for a student. It contains:

- Student ID
- Student name
- Course
- Subject-wise marks
- Total marks
- Percentage
- Grade
- Attendance
- Attendance status
- Overall performance

### Data Storage

Student details, marks, and attendance records are stored in text files inside the `data` folder.

## Technologies Used

- Java Stack
- Git
- Text file storage

## How the System Works

The program starts by displaying a menu to the user.

The user can choose an operation such as adding a student, entering marks, adding attendance, searching for records, analyzing performance, or generating a report.

Before storing the information, the system checks whether the entered data is valid.

The information is then stored in the appropriate text file. When the program is started again, the saved information is loaded from the files.

## Grading System

| Percentage | Grade |
|------------|-------|
| 90–100 | A+ |
| 80–89 | A |
| 70–79 | B |
| 60–69 | C |
| 50–59 | D |
| Below 50 | F |

## Performance Classification

| Marks | Attendance | Performance |
|------|------------|-------------|
| 80% or above | 75% or above | Excellent |
| 60% or above | 75% or above | Good |
| 50% or above | 60% or above | Average |
| Otherwise | - | Needs Improvement |

## Input Validation

The program checks different types of input before processing them.

For example:

- Student ID must be greater than 0.
- Student name cannot be empty.
- Course name cannot be empty.
- Marks must be between 0 and 100.
- Total classes must be greater than 0.
- Attended classes cannot be greater than total classes.
- A student must exist before marks or attendance can be added.

## Testing

A basic test program is included in:

`tests/StudentTest.java`

It checks basic student information and verifies that the Student Manager can successfully store and find a student.

## Author:-

Aditya Das

---
