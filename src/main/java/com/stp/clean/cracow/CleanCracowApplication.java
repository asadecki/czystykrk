package com.stp.clean.cracow;

import com.stp.clean.cracow.config.CleanCracowConfiguration;
import com.stp.clean.cracow.dao.MongoDao;
import com.stp.clean.cracow.resources.RequestResource;
import com.stp.clean.cracow.resources.SayingResource;
import com.stp.clean.cracow.services.RequestService;
import com.stp.clean.cracow.services.SayingService;
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
    }

    @Override
    public void run(CleanCracowConfiguration configuration,
                    Environment environment) {

        /* DAO */
        final MongoDao mongoDao = new MongoDao();

        /* SERVICES */
        final RequestService requestService = new RequestService(mongoDao);
        final SayingService sayingService = new SayingService(mongoDao);

        /* RESOURCES */
        final RequestResource requestResource = new RequestResource(requestService);
        final SayingResource sayingResource = new SayingResource(sayingService);

        environment.jersey().register(requestResource);
        environment.jersey().register(sayingResource);
    }
}