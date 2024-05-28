package com.vpolosov.trainee.merge_xml.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggerConfiguration {

    @Bean
    public Logger customLogger(){
        return LoggerFactory.getLogger("loggerForUser");
    }
}