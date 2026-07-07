package com.java.masterclass.projects.employee;

import java.util.*;

public final class EmployeeManagementApp {
    private EmployeeManagementApp() {}

    public record Employee(long id, String name, String department, double salary) {}

    public static final class EmployeeService {
        private final Map<Long, Employee> employees = new HashMap<>();

        public void upsert(Employee employee) {
            employees.put(employee.id(), employee);
        }

        public List<Employee> byDepartment(String department) {
            return employees.values().stream()
                    .filter(e -> e.department().equalsIgnoreCase(department))
                    .sorted(Comparator.comparing(Employee::id))
                    .toList();
        }
    }
}
