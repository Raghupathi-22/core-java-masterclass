package com.java.masterclass.projects.student;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentManagementAppTest {

    @Test
    void shouldAddAndFindStudents() {
        StudentManagementApp.StudentService service = new StudentManagementApp.StudentService();
        service.add(new StudentManagementApp.Student(10L, "Neo", "neo@example.com"));

        assertTrue(service.findById(10L).isPresent());
        assertEquals(1, service.findAll().size());
    }

    @Test
    void shouldDeleteStudent() {
        StudentManagementApp.StudentService service = new StudentManagementApp.StudentService();
        service.add(new StudentManagementApp.Student(11L, "Trinity", "tri@example.com"));

        assertTrue(service.delete(11L));
        assertFalse(service.findById(11L).isPresent());
    }
}
