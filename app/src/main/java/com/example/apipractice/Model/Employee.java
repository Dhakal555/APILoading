package com.example.apipractice.Model;

public class Employee {
    private int id;
    public String emp_name;
    public float emp_salary;
    public int emp_age;
    public String emp_profile_image;


    public Employee(int id, String emp_name, float emp_salary, int emp_age, String emp_profile_image) {
        this.id = id;
        this.emp_name = emp_name;
        this.emp_salary = emp_salary;
        this.emp_age = emp_age;
        this.emp_profile_image = emp_profile_image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public float getEmp_salary() {
        return emp_salary;
    }

    public void setEmp_salary(float emp_salary) {
        this.emp_salary = emp_salary;
    }

    public int getEmp_age() {
        return emp_age;
    }

    public void setEmp_age(int emp_age) {
        this.emp_age = emp_age;
    }

    public String getEmp_profile_image() {
        return emp_profile_image;
    }

    public void setEmp_profile_image(String emp_profile_image) {
        this.emp_profile_image = emp_profile_image;
    }
}
