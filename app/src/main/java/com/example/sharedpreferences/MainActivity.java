package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et1, et2;
    Button btn1, btn2, btn3;

    SharedPreferences sharedPreferences;

    public static final String myPref = "myPref";
    public static final String name = "nameKey";
    public static final String email = "emailKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrieve();

    }

    public void Save() {
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
//creating the edit text instances
        String n = et1.getText().toString();
        String e = et2.getText().toString();

//Declaring the editor variable
        SharedPreferences.Editor editor = sharedPreferences.edit();

//Adding the data to the editor
        editor.putString(name, n);
        editor.putString(email, e);

//Committing the changes
        editor.commit();
    }

    public void Retrieve() {
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);

//Setting the mode and giving this shared preference a string name
        sharedPreferences = getSharedPreferences(myPref, MODE_PRIVATE);

//if user is opening the app second time the show the stored details that were stored previously
        if(sharedPreferences.contains(name)) et1.setText(sharedPreferences.getString(name, ""));

        if(sharedPreferences.contains(email)) et2.setText(sharedPreferences.getString(email, ""));

    }

    public void Clear() {
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et1.setText("");
        et2.setText("");
    }
}