package com.example.interviewassignemnt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class secound extends AppCompatActivity {
//    public static final String NAME = "NAME";
//    public static final String EMAIL = "EMAIL";
//    String name,email;
    dbhelper Mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secound);
//        TextView nametxt = findViewById(R.id.name);
//        TextView emailtxt = findViewById(R.id.email);
//
//        Intent i = getIntent();
//        name = i.getStringExtra(NAME);
//        email = i.getStringExtra(EMAIL);
//
//        nametxt.setText(name);
//        emailtxt.setText(email);

        ListView list = findViewById(R.id.listview);
        Mydb = new dbhelper(this);

        ArrayList<String> thelist = new ArrayList<>();

        Cursor data = Mydb.getAllData();
        if (data.getCount() == 0){
            Toast.makeText(this, "There are no contents in this list!",Toast.LENGTH_LONG).show();
        }
        else {
            while (data.moveToNext()){
                thelist.add(data.getString(1));
                thelist.add(data.getString(2));
                ListAdapter adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_2, android.R.id.text2,thelist);
                list.setAdapter(adapter1);
            }
//            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, thelist);
//            list.setAdapter(adapter);
        }

    }
}