package com.amit.taskchetu.Activity.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.amit.taskchetu.R;
import com.amit.taskchetu.Utility.Constants;
import com.amit.taskchetu.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityMainBinding binding;
    Context context;
    String gender;
    StringBuffer buffer = new StringBuffer();
    String str = " ";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        context = this;

        binding.allsubmit.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if (!TextUtils.isEmpty(binding.fname.getText().toString()) &&
                !TextUtils.isEmpty(binding.lname.getText().toString())
                && !TextUtils.isEmpty(binding.email.getText().toString()) &&
                !TextUtils.isEmpty(binding.mobileNo.getText().toString())){
            if (binding.mobileNo.getText().toString().length() == 10) {

                if(binding.male.isChecked())
                {
                    gender=binding.male.getText().toString();
                }
                if(binding.female.isChecked())
                {
                    gender=binding.female.getText().toString();
                }

                // TODO : (2) Passing data through Bundle

                Intent intent = new Intent(context, SecondActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString(Constants.FNAME, binding.fname.getText().toString());
                bundle.putString(Constants.LNAME, binding.lname.getText().toString());
                bundle.putString(Constants.EMAIL, binding.email.getText().toString());
                bundle.putString(Constants.PHONENO, binding.mobileNo.getText().toString());
                bundle.putString(Constants.READING, str);
//                bundle.putString(Constants.PLAYING, binding.playing.getText().toString());
//                bundle.putString(Constants.CODING, binding.coding.getText().toString());
//                bundle.putString(Constants.MUSIC, binding.music.getText().toString());
//                bundle.putString(Constants.READING, binding.reading.getText().toString());
                bundle.putString("gender",gender);
                intent.putExtras(bundle);
                startActivity(intent);

            }else {
                Toast.makeText(context, "Please enter valid number", Toast.LENGTH_SHORT).show();
            }


        }else {
            if (TextUtils.isEmpty(binding.fname.getText().toString())){
                binding.fname.setError("Enter first name");
            }else if (TextUtils.isEmpty(binding.lname.getText().toString())){
                binding.lname.setError("Enter last name");
            }else if (TextUtils.isEmpty(binding.email.getText().toString())){
                binding.email.setError("Enter phone number");
            }else if (TextUtils.isEmpty(binding.mobileNo.getText().toString())){
                binding.mobileNo.setError("Enter phone number");
            }
        }
    }

    public void onCheckboxClicked(View view){
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()){
            case R.id.reading:
//                buffer.append(binding.playing.getText().toString());
                str += "Reading";
                break;
            case R.id.music:
//                buffer.append(binding.music.getText().toString());
                str +="Music";
                break;
            case R.id.playing:
//                buffer.append(binding.playing.getText().toString());
                str += "Playing";
                break;
            case R.id.coding:
//                buffer.append(binding.coding.getText().toString());
                str += "Coading";
                break;
        }
       // Toast.makeText(this, str, Toast.LENGTH_LONG).show();
    }
}