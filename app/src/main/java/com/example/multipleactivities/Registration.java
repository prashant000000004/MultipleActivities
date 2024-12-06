package com.example.multipleactivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.multipleactivities.databinding.ActivityRegistrationBinding;

public class Registration extends AppCompatActivity {
    ActivityRegistrationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding=ActivityRegistrationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

// getting the data from the second activity using radio button
        String  selectedOption=getIntent().getStringExtra("selectedOption");
        if(selectedOption!=null){
            binding.txtdepartment.setText(selectedOption);
        }




        binding.btnsubmit.setOnClickListener(view -> {
            String inputname=binding.edtname.getText().toString();
            String inputemail=binding.edtemail.getText().toString();
            String inputid=binding.edtid.getText().toString();
            String inputdep=binding.txtdepartment.getText().toString();
            Intent intent=new Intent(Registration.this,Profile.class);
            intent.putExtra("input1",inputname);
            intent.putExtra("input2",inputemail);
            intent.putExtra("input3",inputid);
            intent.putExtra("input4",inputdep);
            startActivity(intent);
        });
        binding.btnselect.setOnClickListener(view -> {
            Intent intent=new Intent(Registration.this,Department.class);
            startActivity(intent);
        });
    }
}