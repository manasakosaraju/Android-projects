package com.example.manasa.miniproject;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Manasa on 03-11-2016.
 */
public class Bcat extends Activity {

        Button button;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.bcat);

        }

        public void mlrit(View v)
        {
//Uri uri=uri.parse("http://www.bvrit.ac.in/BCategory/2016-2017/Application%20for%20admission%20into%20M.Tech%20%20MBA%20under%20category%20B%20for%20the%20year%202016-2017.PDF");
                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.mlrinstitutions.ac.in/admissions/b-category-seats.html"));
                    startActivity(i);

                }
public void vjit(View v)
{

    Intent i=new Intent(Intent.ACTION_VIEW,Uri.parse("http://vjit.ac.in/admissions/b-tech-b-category-notification/"));
    startActivity(i);
}
public void bvrit(View v)
{
    Intent i=new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.bvrit.ac.in/index.php/b-form"));
    startActivity(i);
}
public void vitb(View v)
{
    Intent i=new Intent(Intent.ACTION_VIEW,Uri.parse("http://vishnu.edu.in/bcat.php"));
    startActivity(i);
}
        }


