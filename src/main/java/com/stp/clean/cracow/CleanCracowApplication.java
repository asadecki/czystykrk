package com.stp.clean.cracow;

import com.stp.clean.cracow.config.CleanCracowConfiguration;
import com.stp.clean.cracow.dao.MongoDao;
import com.stp.clean.cracow.resources.RequestResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class CleanCracowApplication extends Application<CleanCracowConfiguration> {
    public static void main(String[] args) throws Exception {
        new CleanCracowApplication().run(args);
    }

    @Override
    public String getName() {
        return "clean-cracow";
    }

    @Override
    public void initialize(Bootstrap<CleanCracowConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(CleanCracowConfiguration configuration,
                    Environment environment) {

        MongoDao mongoDao = new MongoDao();

        final RequestResource resource = new RequestResource(mongoDao);
        environment.jersey().register(resource);
    }

}