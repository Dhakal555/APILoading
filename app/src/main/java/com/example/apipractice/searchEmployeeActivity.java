package com.example.apipractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apipractice.Interface.EmployeeAPI;
import com.example.apipractice.Model.Employee;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class searchEmployeeActivity extends AppCompatActivity {
    private final static  String BASE_URL = "http://dummy.restapiexample.com/api/v1/";
    private EditText setEmpNo;
    private TextView tvEmpData;
    private Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_employee);

        setEmpNo = findViewById(R.id.setEmpNo);
        btnSearch = findViewById(R.id.sbtnSearch);
        tvEmpData = findViewById(R.id.stvEmpData);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if(validate()){
                    showSearchedData();
//                }
            }
        });
    }

    private boolean validate(){
        if (setEmpNo.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "empty fields", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void showSearchedData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory
                .create()).build();

        EmployeeAPI employeeAPI = retrofit.create(EmployeeAPI.class);

        Call<Employee> callEmployeeList = employeeAPI.getEmployeeByID(Integer.parseInt(setEmpNo.getText().toString()));

        callEmployeeList.enqueue(new Callback<Employee>() {
            @Override
            public void onResponse(Call<Employee> call, Response<Employee> response) {
                Toast.makeText(searchEmployeeActivity.this, response.body().toString(), Toast.LENGTH_SHORT).show();
                String content = "";
                content += "Id : " + response.body().getId() + "\n";
                content += "Name : " + response.body().getEmp_name() + "\n";
                content += "Employee salary : " + response.body().getEmp_salary() + "\n";
                content += "Age : " + response.body().getEmp_age() + "\n";
                content += "Employee Image : " + response.body().getEmp_profile_image() + "\n";

                tvEmpData.setText(content);
            }

            @Override
            public void onFailure(Call<Employee> call, Throwable t) {
                Toast.makeText(searchEmployeeActivity.this, "Data not found", Toast.LENGTH_LONG);
            }
        });
    }
}
