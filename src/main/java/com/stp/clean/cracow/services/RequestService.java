package com.stp.clean.cracow.services;

import com.stp.clean.cracow.dao.MongoDao;
import com.stp.clean.cracow.model.RequestDetails;

import java.util.List;

public class RequestService {

    private final MongoDao mongoDao;

    public RequestService(MongoDao mongoDao) {
        this.mongoDao = mongoDao;
    }

    public void postRequestDetails(RequestDetails requestDetails) {
        mongoDao.addNewRequestDetails(requestDetails);
    }

    public List<RequestDetails> getRequestDetailsList() {
        return mongoDao.getAllRequestDetailsList();
    }
}
