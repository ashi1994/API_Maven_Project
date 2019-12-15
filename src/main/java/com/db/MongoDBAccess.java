package com.db;


import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import java.net.UnknownHostException;
import java.util.Set;


public class MongoDBAccess {


    public static void main(String[] args) throws UnknownHostException {

        // Creating a Mongo client
        MongoClient mongo = new MongoClient("10.0.27.215", 27017);

        //Connect to DBS
        DB db = mongo.getDB("test");
        //Get all collections
        Set<String> colls = db.getCollectionNames();

        for (String s : colls) {
            System.out.println(s);
        }
        //Get a single collection
        DBCollection table = db.getCollection("spins");
        System.out.println(table);

        //Get whole data of specific collection
        DBCollection collection = db.getCollection("spins");
        DBObject dbo = collection.findOne();
        System.out.println(dbo);

        //To get particular column data
        Object name = dbo.get("spin_state");
        Object age = dbo.get("_id");
        System.out.println(name);
        System.out.println(age);


    }

}

