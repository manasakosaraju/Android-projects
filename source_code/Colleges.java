package com.example.manasa.miniproject;

/**
 * Created by Manasa on 16-10-2016.
 */

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import static android.os.StrictMode.ThreadPolicy;
import static android.os.StrictMode.setThreadPolicy;
//@SuppressWarnings("ALL")
public class Colleges extends Activity {
    private static final String url = "jdbc:mysql://169.254.251.1:3306/colleges";
    private static final String user = "root";
    private static final String pass = "";
    public ListView text;
    private Button submit;
    private EditText ranks;
    public String college;
    public EditText et;
    public EditText et2;
    public EditText et3;
    public ArrayList<String> collegeslist;
//public String name;
    int rank;
    String category;
    String gender;
    String[] categoryliststring={"OC","SC","ST"};
    String[] genderliststring={"Male","Female"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.colleges);

        text = (ListView) findViewById(R.id.listView);
        submit = (Button) findViewById(R.id.submit);
        ranks = (EditText) findViewById(R.id.rankedit);
        et=(EditText)findViewById(R.id.editText);
        final AutoCompleteTextView auto=(AutoCompleteTextView)findViewById(R.id.editText2);
        final AutoCompleteTextView autog=(AutoCompleteTextView)findViewById(R.id.editText3);
        et3=(EditText)findViewById(R.id.editText3);
        /*categorylist=new ArrayList<String>();
        genderlist=new ArrayList<String>();*/

        ArrayAdapter adapter=new ArrayAdapter<>(Colleges.this,android.R.layout.simple_dropdown_item_1line,categoryliststring);
        auto.setThreshold(1);
        auto.setAdapter(adapter);
        ArrayAdapter adapternew=new ArrayAdapter<>(Colleges.this,android.R.layout.simple_dropdown_item_1line,genderliststring);
        autog.setThreshold(1);
        autog.setAdapter(adapternew);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rank = Integer.parseInt(et.getText().toString());
                category=auto.getText().toString();
                gender=autog.getText().toString();

// new
                    Display();
                }
                 //      .execute();
                //text.setText(college);


        });

    }





    //@SuppressWarnings("ResourceType")
    public  Void Display()
            //extends AsyncTask<Void, Void, Void>
    {
                    try {
                        ThreadPolicy policy = new ThreadPolicy.Builder().permitAll().build();
                        setThreadPolicy(policy);
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection(url, user, pass);
                        String success = "Database connection successful\n";

                        Statement st = con.createStatement();
                        final ResultSet rs = st.executeQuery("select * from colleges_new where ( '" + rank + "' < close_rank )and (category='" + category + "' ) and (gender='" + gender + "' )");
                        collegeslist = new ArrayList<String>();
                        boolean b = false;
                        while (rs.next()) {

                            collegeslist.add(rs.getString(6));
                            b = true;

                        }

                        if (rank == 0 || category.length() == 0 || gender.length() == 0) {
                            Toast.makeText(getApplicationContext(), "Enter valid details", Toast.LENGTH_LONG).show();
                        }
                        if (!b) {

                                Toast.makeText(getApplicationContext(), "Enter valid rank", Toast.LENGTH_LONG).show();


                        }




                ArrayAdapter adapter= new ArrayAdapter<>(Colleges.this,R.layout.listview,collegeslist);
                text.setAdapter(adapter);



            } catch (Exception e) {
                e.printStackTrace();
                    Toast.makeText(getApplicationContext(),"enter valid details",Toast.LENGTH_LONG).show();

            }


            return null;
        }



    }







