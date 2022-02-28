package com.amit.taskchetu.Activity.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.amit.taskchetu.R;
import com.amit.taskchetu.Utility.Constants;
import com.amit.taskchetu.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    ActivitySecondBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


           Intent intent = getIntent();
           Bundle bundle = intent.getExtras();
           String fname= bundle.getString(Constants.FNAME);
           String lname = bundle.getString(Constants.LNAME);
           String email = bundle.getString(Constants.EMAIL);
           String mobileNo = bundle.getString(Constants.PHONENO);
           String genger = bundle.getString(Constants.GENDER);
           String coading = bundle.getString(Constants.READING);
//           String reading = bundle.getString(Constants.READING);
//           String playing = bundle.getString(Constants.PLAYING);
//           String music = bundle.getString(Constants.MUSIC);


        binding.tvName.setText(fname+ " " + lname);
        binding.tvEmail.setText(email);
        binding.tvNumber.setText(mobileNo);
        binding.tvGender.setText(genger);
        binding.tvCheckbox.setText(coading);


    }
}