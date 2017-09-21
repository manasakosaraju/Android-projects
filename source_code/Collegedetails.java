package com.example.manasa.miniproject;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Collegedetails extends Activity {


//private Button details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collegedetails);
        //TextView  = (TextView)findViewById(R.id.vnr);
        //details = (Button) findViewById(R.id.details);
    }
    public void detailsl (View v)
    {
        Intent i=new Intent(getApplicationContext(),Feedback.class);
        startActivity(i);
    }
    public void feedbackl(View v)
    {
        Intent i=new Intent(getApplicationContext(),Feedback.class);
        startActivity(i);
    }


//@Override
public void vnrl(View v) {
    Uri url= Uri.parse("http://vnrvjiet.ac.in/");;
    Intent i=new Intent(Intent.ACTION_VIEW, url);
    startActivity(i);
}
    public void cbitl(View v) {
        Uri url= Uri.parse("http://cbit.ac.in/");;
        Intent i=new Intent(Intent.ACTION_VIEW, url);
        startActivity(i);
    }
    public void vcel(View v) {
        Uri url= Uri.parse("http://www.vce.ac.in/");;
        Intent i=new Intent(Intent.ACTION_VIEW, url);
        startActivity(i);
    }
    public void grietl(View v) {
        Uri url= Uri.parse("http://www.griet.ac.in/");;
        Intent i=new Intent(Intent.ACTION_VIEW, url);
        startActivity(i);
    }
    public void bvritl(View v) {
        Uri url= Uri.parse("http://www.bvrit.ac.in/");;
        Intent i=new Intent(Intent.ACTION_VIEW, url);
        startActivity(i);
    }
    public void snistl(View v) {
        Uri url= Uri.parse("http://www.sreenidhi.edu.in/");;
        Intent i=new Intent(Intent.ACTION_VIEW, url);
        startActivity(i);
    }
    public void iarel(View v) {
        Uri url= Uri.parse("http://www.iare.ac.in/");;
        Intent i=new Intent(Intent.ACTION_VIEW, url);
        startActivity(i);
    }
    public void oul(View v) {
        Uri url= Uri.parse("http://www.osmania.ac.in/");;
        Intent i=new Intent(Intent.ACTION_VIEW, url);
        startActivity(i);
    }
    public void jntuhl(View v) {
        Uri url= Uri.parse("http://www.jntuhceh.ac.in/");;
        Intent i=new Intent(Intent.ACTION_VIEW, url);
        startActivity(i);
    }
public void logout(View v)
    {
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
