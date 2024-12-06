package com.example.multipleactivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.multipleactivities.databinding.ActivityDepartmentBinding;

public class Department extends AppCompatActivity {
    ActivityDepartmentBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding=ActivityDepartmentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        binding.btnrdselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               int selectedId=binding.rdgrp.getCheckedRadioButtonId();
               if(selectedId!=-1){
                   RadioButton selectedRadioButton=findViewById(selectedId);
                   String selectedtext=selectedRadioButton.getText().toString();
                   Intent intent=new Intent(Department.this,Registration.class);
                   intent.putExtra("selectedOption",selectedtext);
                   startActivity(intent);
               }
            }
        });
    }
}