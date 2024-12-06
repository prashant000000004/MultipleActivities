package com.example.multipleactivities;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.multipleactivities.databinding.ActivityProfileBinding;

public class Profile extends AppCompatActivity {
    ActivityProfileBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding=ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        String input1=getIntent().getStringExtra("input1");
        String input2=getIntent().getStringExtra("input2");
        String input3=getIntent().getStringExtra("input3");
        String input4=getIntent().getStringExtra("input4");
        if(input1!=null) binding.txtname.setText(input1);
        if(input2!=null) binding.txtemail.setText(input2);
        if(input3!=null) binding.txtid.setText(input3);
        if(input4!=null) binding.txtprofiledep.setText(input4);



    }
}