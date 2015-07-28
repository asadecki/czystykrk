package com.stp.clean.cracow.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoURI;
import com.stp.clean.cracow.exception.WrongCredentialsException;
import com.stp.clean.cracow.model.RequestDetails;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/* TODO check Spring support for MongoDB */
public class MongoDao {

    private static final String REQUEST_COLLECTION_NAME = "requests";
    private static final String SAYING_COLLECTION_NAME = "sayings";
    public static final String MONGOLAB_URI = "MONGOLAB_URI";

    private DB mongoDb;

    public MongoDao() {
        try {
            MongoURI mongoURI = new MongoURI(System.getenv(MONGOLAB_URI));
            DB mongoDb = mongoURI.connectDB();
            authenticate(mongoURI, mongoDb);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public void addNewRequestDetails(RequestDetails requestDetails) {
        DBCollection table = this.mongoDb.getCollection(REQUEST_COLLECTION_NAME);
        table.insert(buildBasicDBObjectFromRequestDetails(requestDetails));
    }

    public void addNewSaying(String saying) {
        DBCollection table = this.mongoDb.getCollection(SAYING_COLLECTION_NAME);
        table.insert(buildBasicDBObjectFromString(saying));
    }

    public List<RequestDetails> getAllRequestDetailsList() {
        List<RequestDetails> requestDetailsList = new ArrayList<>();
        DBCollection table = this.mongoDb.getCollection(REQUEST_COLLECTION_NAME);
        DBCursor cursor = table.find();
        while (cursor.hasNext()) {
            DBObject document = cursor.next();
            RequestDetails requestDetails = buildRequestDetailsFromBasicDBObject(document);
            requestDetailsList.add(requestDetails);
        }

        return requestDetailsList;
    }

    public String getRandomSaying() {
        long table = this.mongoDb.getCollection(SAYING_COLLECTION_NAME).count();

        return "dupa";
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

    private BasicDBObject buildBasicDBObjectFromString(String saying) {
        BasicDBObject document = new BasicDBObject();
        document.put("saying", saying);
        return document;
    }

    private RequestDetails buildRequestDetailsFromBasicDBObject(DBObject document) {
        RequestDetails requestDetails = new RequestDetails();

        requestDetails.setEmail(String.valueOf(document.get("email")));
        requestDetails.setUserName(String.valueOf(document.get("userName")));
        requestDetails.setLatitude(Double.parseDouble(document.get("latitude").toString()));
        requestDetails.setLongitude(Double.parseDouble(document.get("longitude").toString()));
        requestDetails.setPhoneNumber(String.valueOf(document.get("phoneNumber")));

        requestDetails.setPhotos((List<String>) document.get("photos"));
        return requestDetails;
    }
}
