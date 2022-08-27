package com.example.interviewassignemnt;

import static com.example.interviewassignemnt.dbhelper.email;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    dbhelper mydb = new dbhelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText name = findViewById(R.id.name);
        EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.password);
        Button submit = findViewById(R.id.submit);
        ConstraintLayout mainlayout = findViewById(R.id.mainlayout);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameText = name.getText().toString();
                String emailText = email.getText().toString();
                String passwordText = password.getText().toString();
                boolean emaill = Patterns.EMAIL_ADDRESS.matcher(emailText).matches();
                boolean check = mydb.checkdata(nameText,emailText,passwordText);

                if (nameText.isEmpty() || passwordText.isEmpty()) {
                    Snackbar.make(mainlayout, "Please fill all the fields", Snackbar.LENGTH_LONG).show();
                }else if (!emaill) {
                    Snackbar.make(mainlayout, "Email invalid", Snackbar.LENGTH_LONG).show();
                }else  {
//                    Snackbar.make(mainlayout, "Data added", Snackbar.LENGTH_LONG).show();
//                    boolean check = mydb.checkdata(nameText,emailText);
                    if (check == false){
                        Intent i = new Intent(MainActivity.this, display.class);
                        i.putExtra(display.NAME, nameText);
                        i.putExtra(display.EMAIL, emailText);
                        startActivity(i);
                        adddata(nameText,emailText,passwordText);
                    }else{

                        Intent i = new Intent(MainActivity.this, secound.class);
                        startActivity(i);
                    }

                }
            }
        });
    }
    public void adddata(String name,String email,String password){
        boolean insert = mydb.addItem(name, email, password);
        if (insert == true){
            Snackbar.make(findViewById(R.id.mainlayout), "Data inserted", Snackbar.LENGTH_SHORT).show();
        }else {
            Snackbar.make(findViewById(R.id.mainlayout), "Data not inserted", Snackbar.LENGTH_SHORT).show();
        }
    }



}