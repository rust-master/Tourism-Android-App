package com.zaryab.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText user,pass;
    String U = "admin";
    String P = "admin";
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = (EditText) findViewById(R.id.user);
        pass = (EditText) findViewById(R.id.pass);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uu=user.getText().toString();
                String pp = pass.getText().toString();
                if(U.equals(uu) && P.equals(pp))
                {

                    Intent homeIntent = new Intent(MainActivity.this,Home.class);
                    startActivity(homeIntent);
                }
                else{
                    Toast.makeText(MainActivity.this, "Worng", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
