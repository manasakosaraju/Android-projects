package com.example.manasa.miniproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Manasa on 30-10-2016.
 */
public class Student extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student);
    }
    public void details(View v)
    {
        Intent i=new Intent(this,Collegedetails.class);
        startActivity(i);

    }
    public void feedback(View v)
    {
        Intent i=new Intent(this,Feedback.class);
        startActivity(i);
    }
    public void estimate(View v)
    {
        Intent i=new Intent(this,Colleges.class);
        startActivity(i);
    }
    public void logout(View v)
    {
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }
    public void bcat(View v)
    {
        Intent i=new Intent(this,Bcat.class);
        startActivity(i);
    }
}

