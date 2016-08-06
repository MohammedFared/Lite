package com.example.fareed.lite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ItemsList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.items_list);
        Intent intent = getIntent();
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.items_list, R.id.itemText, intent.getStringArrayExtra("array"));
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(arrayAdapter);
    }
}
