package com.example.manasa.miniproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Manasa on 30-10-2016.
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void student(View v)
    {
        Intent i=new Intent(this,Forum.class);
        startActivity(i);
    }

public void fresher(View v)
{
    Intent i=new Intent(this,Fresher_login.class);
    startActivity(i);
}
}
