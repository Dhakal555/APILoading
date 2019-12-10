package com.example.apipractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.apipractice.Interface.EmployeeAPI;
import com.example.apipractice.Model.Employee;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView tvData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvData = findViewById(R.id.tvData);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://dummy.restapiexample.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        EmployeeAPI employeeAPI = retrofit.create(EmployeeAPI.class);
        Call<List<Employee>> listCall = employeeAPI.getEmployee();

        listCall.enqueue(new Callback<List<Employee>>() {
            @Override
            public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
                if (!response.isSuccessful()){
                    tvData.setText(("Code :" + response.code()));
                    return;
                }

                List<Employee> employeeList = response.body();
                for (Employee employee : employeeList){
                    String content = "";
                    content += "ID : " + employee.getId() + "\n";
                    content += "employee_name : " + employee.getEmp_name() + "\n";
                    content += "employee_salary : " + employee.getEmp_salary() + "\n";
                    content += "employee_age : " + employee.getEmp_age() + "\n";
                    content += "profile_image : " + employee.getEmp_profile_image() + "\n";

                    tvData.append(content);

                }
            }

            @Override
            public void onFailure(Call<List<Employee>> call, Throwable t) {
                tvData.setText("Error"+ t.getMessage());
            }
        });
    }
}
