package com.example.ass2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    //declare global variables - can be used in all classes
    //declare as com.example.ProjectName.InputBoxName
    public static final String MESSAGE_Name = "com.example.ass2.txtName";
    public static final String MESSAGE_Post = "com.example.ass2.txtPost";

    //Declare Variable types
    EditText txtName, txtPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //find or reference Variables
        txtName = findViewById(R.id.txtName);
        txtPost = findViewById(R.id.txtPost);
    }
    public void postCheck(View v) {
        //Declare variables and place linked text within String
        String stName = txtName.getText().toString();
        String stPost = txtPost.getText().toString();

        //Create Intent(What is changed?, With what class?)
        Intent intent = new Intent(this, CustData.class);

        //pass input boxes and values through the intent
        intent.putExtra(MESSAGE_Name, stName);
        intent.putExtra(MESSAGE_Post, stPost);

        //Start Intent
        startActivity(intent);
    }

    public void webVisit(View v){
        //String for website
        String WebSt = "https://www.amazon.com";

        Intent webInt = new Intent(Intent.ACTION_VIEW, Uri.parse(WebSt));

        if(webInt.resolveActivity(getPackageManager())!= null){
            startActivity(webInt);
        }

    }













}
