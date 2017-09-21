package com.example.manasa.miniproject;

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

/**
 * Created by Manasa on 30-10-2016.
 */
public class Fresher_login extends Activity {
    private static final String url = "jdbc:mysql://169.254.251.1:3306/colleges";
    private static final String user = "root";
    private static final String pass = "";
    String ul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fresher_login);
        Button login = (Button) findViewById(R.id.login);
        final EditText username = (EditText) findViewById(R.id.user);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ul = username.getText().toString();
                loginc();
            }
        });
    }

    public void loginc() {
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            setThreadPolicy(policy);
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            //String success = "Database connection successful\n";
            Statement st = con.createStatement();
                final ResultSet rs = st.executeQuery("select * from student where username='" + ul + "'");
                if (!rs.next()) {
                    Toast.makeText(getApplicationContext(), "invalid username or password", Toast.LENGTH_LONG).show();
                } else {
                    Intent i = new Intent(getApplicationContext(), Student.class);
                    startActivity(i);
                }


        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}