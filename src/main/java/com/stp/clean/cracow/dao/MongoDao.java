package com.stp.clean.cracow.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoURI;
import com.stp.clean.cracow.exception.WrongCredentialsException;
import com.stp.clean.cracow.model.RequestDetails;

import java.net.UnknownHostException;
import java.util.Map;

public class MongoDao {

    private static final String REQUEST_COLLECTION_NAME = "requests";

    private DB mongoDb;

    public MongoDao() {
        try {
            Map<String, String> xx = System.getenv();
            MongoURI mongoURI = new MongoURI(System.getenv("MONGOLAB_URI"));
            DB mongoDb = mongoURI.connectDB();
            authenticate(mongoURI, mongoDb);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public void addNewRequestDetails(RequestDetails requestDetails) {
        DBCollection table = mongoDb.getCollection(REQUEST_COLLECTION_NAME);
        table.insert(buildBasicDBObjectFromRequestDetails(requestDetails));
    }

    private void authenticate(MongoURI mongoURI, DB mongoDb) {
        if (mongoURI.getUsername() != null && mongoDb.authenticate(mongoURI.getUsername(), mongoURI.getPassword())) {
            this.mongoDb = mongoDb;
        } else {
            throw new WrongCredentialsException("Wrong user or password");
        }
    }

    private BasicDBObject buildBasicDBObjectFromRequestDetails(RequestDetails requestDetails) {
        BasicDBObject document = new BasicDBObject();

        document.put("userName", requestDetails.getUserName());
        document.put("email", requestDetails.getEmail());
        document.put("latitude", requestDetails.getLatitude());
        document.put("longitude", requestDetails.getLongitude());
        document.put("phoneNumber", requestDetails.getPhoneNumber());
        document.put("photos", requestDetails.getPhotos());

        return document;
    }
}
