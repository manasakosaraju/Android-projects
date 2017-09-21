package com.example.manasa.miniproject;

/**
 * Created by Manasa on 16-10-2016.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static android.os.StrictMode.setThreadPolicy;

//@SuppressWarnings("ALL")
public class Forum extends Activity {
    private static final String url = "jdbc:mysql://169.254.251.1:3306/colleges";
    private static final String user = "root";
    private static final String pass = "";
    //public Button login;
    //public Button Register;
    //public EditText username;
    //public EditText email;
    public EditText password;

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    public String u;
    public String p;
    public String e;
    public String ul;
    public String pl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forum);
        Button login = (Button) findViewById(R.id.login);
        Button register = (Button) findViewById(R.id.register);
        final EditText username = (EditText) findViewById(R.id.userr);
        final EditText email = (EditText) findViewById(R.id.emailr);
        final EditText password = (EditText) findViewById(R.id.passr);
        final EditText userlv = (EditText) findViewById(R.id.userl);
        final EditText passlv = (EditText) findViewById(R.id.passl);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                u = username.getText().toString();
                p = password.getText().toString();
                e = email.getText().toString();


                Registerc();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ul = userlv.getText().toString();
                pl = passlv.getText().toString();
                loginc();
            }
        });
    }

    public Void Registerc()
    //extends AsyncTask<Void, Void, Void>
    {
        //public String college="";

        // @Override
        // protected Void doInBackground(Void... params) {
        //   public String college;
        // @Override
        //protected Void doInBackground(Void... params) {
        //public Void testDB() {


        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            setThreadPolicy(policy);
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            //String success = "Database connection successful\n";
            Statement st = con.createStatement();

            if(u.length()==0||e.length()==0||p.length()==0)
            {
                Toast.makeText(getApplicationContext(),"Enter all details",Toast.LENGTH_LONG).show();
            }
            else {
                if (!e.matches(emailPattern)) {
                    Toast.makeText(getApplicationContext(), "invalid email address", Toast.LENGTH_SHORT).show();
                } else {
                    st.executeUpdate("INSERT INTO register(username,email,password)values('" + u + "','" + e + "','" + p + "')");
                    Toast.makeText(getApplicationContext(),"Registered Successfully",Toast.LENGTH_LONG).show();
                }
            }

        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e1) {
            e1.printStackTrace();
            Toast.makeText(getApplicationContext(), "Username exists.Find other", Toast.LENGTH_LONG).show();
            Toast.makeText(getApplicationContext(), "Email exists", Toast.LENGTH_LONG).show();
        }
        return null;
    }

    public void loginc() {
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            setThreadPolicy(policy);
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            //String success = "Database connection successful\n";
            Statement st = con.createStatement();
            final ResultSet rs = st.executeQuery("select * from register where username='" + ul + "' && password='" + pl + "'");
            if (!rs.next()) {
                Toast.makeText(getApplicationContext(), "invalid username or password", Toast.LENGTH_LONG).show();
            } else {
                Intent i = new Intent(getApplicationContext(), Forum_feedback.class);
                startActivity(i);
            }

        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}