package com.example.interviewassignemnt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class display extends AppCompatActivity {
    public static final String NAME = "NAME";
    public static final String EMAIL = "EMAIL";
    String name,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        TextView nametxt = findViewById(R.id.name);
        TextView emailtxt = findViewById(R.id.email);

        Intent i = getIntent();
        name = i.getStringExtra(NAME);
        email = i.getStringExtra(EMAIL);

        nametxt.setText(name);
        emailtxt.setText(email);
    }
}