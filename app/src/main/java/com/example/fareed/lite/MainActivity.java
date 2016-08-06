package com.example.fareed.lite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.activeandroid.ActiveAndroid;

import java.util.Arrays;
import java.util.List;



public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public List<Item> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActiveAndroid.initialize(this);
        Button create = (Button) findViewById(R.id.create);
        create.setOnClickListener(this);
        Button update = (Button) findViewById(R.id.update);
        update.setOnClickListener(this);
        Button select = (Button) findViewById(R.id.select);
        select.setOnClickListener(this);
        Button delete = (Button) findViewById(R.id.delete);
        delete.setOnClickListener(this);
    }
    String[] itemsarray = new String[20];
    @Override
    public void onClick(View view) {
        if(R.id.create == view.getId()){
            // Create an item
            Item item = new Item();
            item.name = "Outback Steakhouse";
            item.save();
        }
        else if (R.id.delete == view.getId()){
            Item.delete(Item.class, 1);
        }
        else if (R.id.select == view.getId()){
            items = Item.getAll();
            int i=0;
            TextView textView = (TextView) findViewById(R.id.textView);
            for (Item item : items) {
                itemsarray[i]=item.name;
                i++;
            }
            textView.setText(Arrays.toString(itemsarray));
            Log.d("bla", "onClick: "+ Arrays.toString(itemsarray));
        }
        else if (R.id.update == view.getId()){
            Item item = items.get(0);
            item.name = "Fareed";
            item.save();
        }
    }
}
