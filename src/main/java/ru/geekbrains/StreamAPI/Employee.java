package ru.geekbrains.StreamAPI;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Employee {
    public String name;
    public int age;
    public double salary;
    public String department;

    public Employee(String name, int age, double salary, String department) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
//        return "Employee{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                ", salary=" + salary +
//                ", department='" + department + '\'' +
//                '}';
        return String.format("[%s] Age: %s y.o.; Salary: %s $; Department: %s", name, age, salary, department);
    }

    public static Map<String, List<Employee>> EmployeesByDepartments(List<Employee> employeeList) {
        return employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    public static Map<String,Double> AverageSalaryByDepartments(List<Employee> employeeList) {
        return employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));
    }
}

