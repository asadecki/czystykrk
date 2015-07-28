package com.stp.clean.cracow.services;

import com.stp.clean.cracow.dao.MongoDao;

public class SayingService {

    private final MongoDao mongoDao;

    public SayingService(MongoDao mongoDao) {
        this.mongoDao = mongoDao;
    }

    public void postSaying(String saying) {
        mongoDao.addNewSaying(saying);
    }

    public String getSaying() {

    }
}
