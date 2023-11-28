package ru.geekbrains.StreamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
2. Создать класс Employee (Сотрудник) с полями: String name, int age, double salary, String department
   * 2.1 Создать список из 10-20 сотрудников
   * 2.2 Вывести список всех различных отделов (department) по списку сотрудников
   * 2.3 Всем сотрудникам, чья зарплата меньше 10_000, повысить зарплату на 20%
   * 2.4 * Из списка сотрудников с помощью стрима создать Map<String, List<Employee>> с отделами и сотрудниками внутри отдела
   * 2.5 * Из списока сорудников с помощью стрима создать Map<String, Double> с отделами и средней зарплатой внутри отдела
 */

public class Main {
    public static void main(String[] args) {

        System.out.println("\n2.1 Создать список из 10-20 сотрудников");

        List<Employee> employeeList = List.of(
                new Employee("Sergei", 42, 12500.00, "Sales"),
                new Employee("Maxim", 38, 2500.00, "Sales"),
                new Employee("Ilya", 40, 2700.00, "Technical"),
                new Employee("Fanur", 37, 3500.00, "Technical"),
                new Employee("Petr", 55, 11900.00, "Logistics"),
                new Employee("Elena", 40, 2850.00, "Sales"),
                new Employee("Alexander", 29, 2100.00, "Technical"),
                new Employee("Kseniya", 25, 2200.00, "Sales"),
                new Employee("Boris", 27, 2500.00, "Logistics"),
                new Employee("Nikita", 23, 12000.00, "Sales"),
                new Employee("Vasiliy", 33, 3500.00, "Technical"),
                new Employee("Roman", 26, 4000.00, "Sales"),
                new Employee("Pavel", 25, 15000.00, "Technical"),
                new Employee("Anastasia", 34, 15500.00, "Logistics")
        );

        System.out.println(employeeList);

        System.out.println("\n2.2 Вывести список всех различных отделов (department) по списку сотрудников");

        employeeList.stream()
                .map(Employee::getDepartment)
                .distinct()
                .forEach(System.out::println);

        System.out.println("\n2.3 Всем сотрудникам, чья зарплата меньше 10_000, повысить зарплату на 20%\n");

        employeeList.stream()
                .filter(it -> it.getSalary() < 10_000)
                .flatMap(it -> Stream.of(
                        String.format("Сотрудник: %s; Департамент: %s; Зарплата до повышения: %s / После повышения: %s", it.getName(), it.getDepartment(), it.getSalary(), (it.getSalary() * 1.2))))
                .forEach(System.out::println);
    }
}