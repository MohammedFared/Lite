package com.example.fareed.lite;

/**
 * Created by Mohammed Fareed on 8/6/2016.
 */

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

@Table(name = "Items")
public class Item extends Model {
    // This is the unique id given by the server
    // This is a regular field
    @Column(name = "Name")
    public String name;
    // This is an association to another activeandroid model

    // Make sure to have a default constructor for every ActiveAndroid model
    public Item(){
        super();
    }

    public Item(int remoteId, String name){
        super();
        this.name = name;
    }

    public static List<Item> getAll() {
        // This is how you execute a query
        return new Select()
                .from(Item.class)
                .execute();
    }
}

