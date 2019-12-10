package com.example.apipractice.Interface;

import com.example.apipractice.Model.Employee;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface EmployeeAPI {
    // Getting all the employees
    @GET("employees")
    Call<List<Employee>> getEmployee();

    // Getting employee on the basis of emp id
    @GET("employees/{empID}")
    Call<Employee> getEmployeeByID(@Path("empID") int empID);
}
