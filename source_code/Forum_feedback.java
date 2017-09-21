package com.example.manasa.miniproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static android.os.StrictMode.setThreadPolicy;

/**
 * Created by Manasa on 29-10-2016.
 */
public class Forum_feedback  extends Activity {

    private static final String url = "jdbc:mysql://169.254.251.1:3306/colleges";
    private static final String user = "root";
    private static final String pass = "";
    public ArrayList<String> collegeslist;
    Button submit;
    String c;
    String f;
    boolean b=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forum_feedback);
        feedback();
        final AutoCompleteTextView college=(AutoCompleteTextView)findViewById(R.id.auto);
        final EditText feed=(EditText)findViewById(R.id.feedback);
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c=college.getText().toString();
                f=feed.getText().toString();
                feedtake();
            }
        });
    }
    public void view(View v)
    {
        Intent i=new Intent(this,Feedback.class);
        startActivity(i);
    }
    public void logout(View v)
    {
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }
    public void feedback() {
        try {

             AutoCompleteTextView act = (AutoCompleteTextView) findViewById(R.id.auto);
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            setThreadPolicy(policy);
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            //String success = "Database connection successful\n";
            Statement st = con.createStatement();
            final ResultSet rs = st.executeQuery("select * from colleges");
            collegeslist=new ArrayList<String>();

            while (rs.next()) {
collegeslist.add(rs.getString(2));

            }
            ArrayAdapter adapter=new ArrayAdapter<>(Forum_feedback.this,android.R.layout.simple_dropdown_item_1line,collegeslist);
            act.setThreshold(1);
            act.setAdapter(adapter);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void feedtake()
    {

        try {

          StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            setThreadPolicy(policy);
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            //String success = "Database connection successful\n";
            Statement st = con.createStatement();
            if(c.length()>0&&f.length()>0) {
                st.executeUpdate("INSERT INTO feedback(college,feedback)values('" + c + "','" + f + "')");
                Toast.makeText(getApplicationContext(), "Recorded successfully", Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(getApplicationContext(),"Enter valid details",Toast.LENGTH_LONG).show();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(),"Enter valid college name",Toast.LENGTH_LONG).show();
        }
    }
}

