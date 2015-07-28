package com.stp.clean.cracow.services;

import com.stp.clean.cracow.dao.MongoDao;
import com.stp.clean.cracow.model.Saying;

public class SayingService {

    private final MongoDao mongoDao;

    public SayingService(MongoDao mongoDao) {
        this.mongoDao = mongoDao;
    }

    public void postSaying(Saying saying) {
        mongoDao.addNewSaying(saying);
    }

    public String getSaying() {
        return mongoDao.getRandomSaying();
    }
}
