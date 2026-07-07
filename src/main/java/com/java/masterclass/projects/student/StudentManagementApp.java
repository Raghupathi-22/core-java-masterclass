package com.java.masterclass.projects.student;

import java.util.*;

public final class StudentManagementApp {
    private StudentManagementApp() {}

    public record Student(long id, String name, String email) {}

    public static final class StudentService {
        private final Map<Long, Student> storage = new HashMap<>();

        public void add(Student student) {
            storage.put(student.id(), student);
        }

        public Optional<Student> findById(long id) {
            return Optional.ofNullable(storage.get(id));
        }

        public List<Student> findAll() {
            return storage.values().stream().sorted(Comparator.comparing(Student::id)).toList();
        }

        public boolean delete(long id) {
            return storage.remove(id) != null;
        }
    }

    public static void demo() {
        StudentService service = new StudentService();
        service.add(new Student(1, "Asha", "asha@example.com"));
        service.add(new Student(2, "Ravi", "ravi@example.com"));
        System.out.println("Students count: " + service.findAll().size());
    }
}
