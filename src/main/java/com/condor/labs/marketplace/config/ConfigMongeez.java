package com.condor.labs.marketplace.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.mongodb.Mongo;
import org.mongeez.Mongeez;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class ConfigMongeez {

    private static final Logger LOGGER = LogManager.getLogger(ConfigMongeez.class.getName());

    @Value("${mongeez.classpath}")
    private String initialLoadingFile;

    @Value("${spring.data.mongodb.database}")
    private String databaseName;

    @Bean(initMethod = "process")
    public Mongeez loadInitialData(final Mongo mongo) {
        LOGGER.info("Initializing default data");
        final Mongeez mongeez = new Mongeez();
        mongeez.setMongo(mongo);
        mongeez.setDbName(databaseName);
        mongeez.setFile(new ClassPathResource(initialLoadingFile));
        return mongeez;
    }
}
