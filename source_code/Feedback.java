package com.example.manasa.miniproject;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
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
public class Feedback extends Activity {
    private static final String url = "jdbc:mysql://169.254.251.1:3306/colleges";
    private static final String user = "root";
    private static final String pass = "";
    String c;
    public ListView text;
  Button submit;
    public ArrayList<String> feedbacklist;
public ArrayList<String> collegelist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback);
        text = (ListView) findViewById(R.id.listView);

        feedback();
       final AutoCompleteTextView college=(AutoCompleteTextView)findViewById(R.id.auto);
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           c = college.getText().toString();
                feedshow();
            }
        });


    }


    public void feedback() {
        try {


            AutoCompleteTextView act = (AutoCompleteTextView) findViewById(R.id.auto);
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            setThreadPolicy(policy);
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            String success = "Database connection successful\n";
            Statement st = con.createStatement();
            final ResultSet rs=st.executeQuery("select * from colleges");
           //ResultSetMetaData rsmd = rs.getMetaData();)
            //ArrayList<String> lists = new ArrayList<String>();
            //feedbacklist = new ArrayList<String>();
            collegelist=new ArrayList<String>();
String c;
            while (rs.next()) {
  collegelist.add(rs.getString(2));
            }


            ArrayAdapter adapter=new ArrayAdapter<>(Feedback.this,android.R.layout.simple_dropdown_item_1line,collegelist);
            act.setThreshold(1);
            act.setAdapter(adapter);

            }
             catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void feedshow()
    {
        try {

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            setThreadPolicy(policy);
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            //String success = "Database connection successful\n";
            Statement st = con.createStatement();
           final ResultSet rs= st.executeQuery("select * from feedback where college='" + c + "'");
            feedbacklist=new ArrayList<String>();
//Boolean a=rs.next();
           /* if (!rs.next())
            {
                Toast.makeText(getApplicationContext(),"No feedback available",Toast.LENGTH_LONG).show();
            }*/
            if(c.length()>0) {

                while (rs.next())
                    feedbacklist.add(rs.getString(3));

            }



            else
            {
                Toast.makeText(getApplicationContext(),"Enter valid details",Toast.LENGTH_LONG).show();
            }
            // Toast.makeText(getApplicationContext(), college, Toast.LENGTH_LONG).show();
            // text.setText(college);
            // ArrayAdapter    <String> adapter=new ArrayAdapter<String>(this,R.layout.colleges_main,collegeslist);
            ArrayAdapter adapter= new ArrayAdapter<>(Feedback.this,R.layout.feedback_listview,feedbacklist);
            text.setAdapter(adapter);
            //Toast.makeText(getApplicationContext(), "Recorded successfully", Toast.LENGTH_LONG).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
