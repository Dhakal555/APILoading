package com.example.apipractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard extends AppCompatActivity implements View.OnClickListener {
    Button btnAllEmp, btnEmpSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btnAllEmp = findViewById(R.id.btnAllEmp);
        btnAllEmp.setOnClickListener(this);

        btnEmpSearch = findViewById(R.id.search);
        btnEmpSearch.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAllEmp) {

            Intent intentGetAll = new Intent(Dashboard.this, MainActivity.class);
            startActivity(intentGetAll);
        } else if (v.getId() == R.id.search){

            Intent intentSearch = new Intent(Dashboard.this, searchEmployeeActivity.class);
            startActivity(intentSearch);
        }
    }
}
