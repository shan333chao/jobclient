package com.tutorchat.configration;

import com.mongodb.MongoClientURI;
import com.tutorchat.core.BaseMongoRepositoryImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.net.UnknownHostException;

/**
 * @author Ykun 于 2017-06-16 16:15
 */
@Configuration
public class MongoConfigration {

    @Value("${mongodb.shbasic.uri}")
    private String shbasicURI;

    @Value("${mongodb.tpbasic.uri}")
    private String tpbasicSlaveURI;

    @Value("${mongodb.shmessage.uri}")
    private String shmessageURI;

    @Value("${mongodb.tpmessage.uri}")
    private String tpmessageURI;

    @Bean(name = "shbasicTemplate")
    public MongoTemplate shbasicTemplate() throws UnknownHostException {
        return new MongoTemplate(new SimpleMongoDbFactory(new MongoClientURI(shbasicURI)));
    }

    @Bean(name = "tpbasicTemplate")
    public MongoTemplate tpbasicTemplate() throws UnknownHostException {
        return new MongoTemplate(new SimpleMongoDbFactory(new MongoClientURI(tpbasicSlaveURI)));
    }
    @Bean(name = "shmessageTemplate")
    public MongoTemplate shmessageTemplate() throws UnknownHostException {
        return new MongoTemplate(new SimpleMongoDbFactory(new MongoClientURI(shmessageURI)));
    }

    @Bean(name = "tpmessageTemplate")
    public MongoTemplate tpmessageTemplate() throws UnknownHostException {
        return new MongoTemplate(new SimpleMongoDbFactory(new MongoClientURI(tpmessageURI)));
    }

    @EnableMongoRepositories(basePackages = "com.tutorchat.repository.basicinfo", mongoTemplateRef = "shbasicTemplate", repositoryBaseClass = BaseMongoRepositoryImpl.class)
    private class SHbasicMongoConfigration {

    }

    @EnableMongoRepositories(basePackages = "com.tutorchat.repository.basicinfo", mongoTemplateRef = "tpbasicTemplate", repositoryBaseClass = BaseMongoRepositoryImpl.class)
    private class TPbasicConfigration {

    }

    @EnableMongoRepositories(basePackages = "com.tutorchat.repository.message", mongoTemplateRef = "shmessageTemplate", repositoryBaseClass = BaseMongoRepositoryImpl.class)
    private class SHmessageMongoConfigration {

    }

    @EnableMongoRepositories(basePackages = "com.tutorchat.repository.message", mongoTemplateRef = "tpmessageTemplate", repositoryBaseClass = BaseMongoRepositoryImpl.class)
    private class TPmessageMongoConfigration {

    }
}
