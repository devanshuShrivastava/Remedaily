/*Creator Aditya Gadhvi*/
package com.example.devan.remedaily.View;

//Importing all the necessary packages
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.devan.remedaily.R;
import com.example.devan.remedaily.businesslayer.UserDetailsBusinessLayer;
import com.example.devan.remedaily.datalayer.AppDatabase;


public class UserDetails extends AppCompatActivity {

    //Declaring the Views and variables.
    public TextView firstNameTv,lastNameTv,ageTv;
    public EditText firstNameEd,lastNameEd,ageEd;
    public Button saveBtn, cancelBtn;
    public TextView firstNameError,lastNameError,ageError,showDB;
    public String firstName,lastName,age;
    public Context context;
    private boolean firstNameValidate = true,lastNameValidate = true,ageValidate = true;
    public AppDatabase appData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Initializing the different views and context
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        appData = AppDatabase.getInMemoryDatabase(getApplicationContext());
        firstNameEd=findViewById(R.id.editTextFirstName);
        lastNameEd=findViewById(R.id.editTextLastName);
        ageEd=findViewById(R.id.editTextAge);
        saveBtn=findViewById(R.id.saveBtn);
        firstNameError=findViewById(R.id.firstNameValidateLbl);
        lastNameError=findViewById(R.id.lastNameValidateLbl);
        ageError=findViewById(R.id.ageValidateLbl);
        firstNameTv=findViewById(R.id.firstNameLbl);
        lastNameTv=findViewById(R.id.lastNameLbl);
        ageTv=findViewById(R.id.ageLbl);
        cancelBtn = findViewById(R.id.cancelBtn);
        context=this;


        //Click functionality of the save button
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Validations();

                if(firstNameValidate && lastNameValidate && ageValidate){ //The data will only be inserted if all of the flags are true. Otherwise it will execute the else part and data will not be inserted.
                    try {
                        UserDetailsBusinessLayer.InsertRecordsAsync(appData,firstNameEd.getText().toString(),lastNameEd.getText().toString(),ageEd.getText().toString());
                        Intent intent = new  Intent(getApplicationContext(),Hamburger.class);
                        startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(),"Enter valid data",Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Click functionality of the cancel button
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*TODO*/
            }
        });

        //Focus methods to determine whether the user clicked on the edittext or not.

        firstNameEd.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    firstNameTv.setTextColor(ContextCompat.getColor(context, R.color.focus));

                }
                else {
                    firstNameTv.setTextColor(ContextCompat.getColor(context, R.color.notFocus));
                }
            }
        });

        lastNameEd.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    lastNameTv.setTextColor(ContextCompat.getColor(context, R.color.focus));

                }
                else {
                    lastNameTv.setTextColor(ContextCompat.getColor(context, R.color.notFocus));
                }
            }
        });

        ageEd.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    ageTv.setTextColor(ContextCompat.getColor(context, R.color.focus));

                }
                else {
                    ageTv.setTextColor(ContextCompat.getColor(context, R.color.notFocus));
                }
            }
        });
    }

    //A method to validate the user input. Different flags are used in this method. These flags will become true if the input is true, otherwise they will become false.
    public void Validations(){

        firstName=firstNameEd.getText().toString();
        if(firstName.matches("")) {
            firstNameError.setText("\u274C"+"First name is required"+"\u274C");
            firstNameError.setVisibility(View.VISIBLE);
            firstNameValidate =false;
        }
        else {
            if (firstName.matches("[a-zA-Z]*")) {
                firstNameError.setVisibility(View.INVISIBLE);
                firstNameValidate =true;

            }
            else {
                firstNameError.setText("\u274C"+"Please enter a valid first name!!!"+"\u274C");
                firstNameError.setVisibility(View.VISIBLE);
                firstNameValidate =false;

            }
        }

        lastName=lastNameEd.getText().toString();
        if(lastName.matches("")) {
            lastNameError.setText("\u274C"+"Last name is required"+"\u274C");
            lastNameError.setVisibility(View.VISIBLE);
            lastNameValidate =false;
        }
        else {
            if (lastName.matches("[a-zA-Z]*")) {
                lastNameError.setVisibility(View.INVISIBLE);
                saveBtn.setEnabled(true);
                lastNameValidate =true;
            }
            else {
                lastNameError.setText("\u274C"+"Please enter a valid last name!!!"+"\u274C");
                lastNameError.setVisibility(View.VISIBLE);
                lastNameValidate =false;
            }
        }

        age=ageEd.getText().toString();
        if(age.matches("")) {
            ageError.setText("\u274C"+"Age is required"+"\u274C");
            ageError.setVisibility(View.VISIBLE);
            ageValidate =false;
        }
        else {

            if(Integer.parseInt(age)>0 && Integer.parseInt(age)<=125) {
                ageError.setVisibility(View.INVISIBLE);
                ageValidate =true;
            }
            else {
                ageError.setText("\u274C"+"Please enter a valid age!!!"+"\u274C");
                ageError.setVisibility(View.VISIBLE);
                ageValidate =false;
            }
        }

    }
}

