package com.vpolosov.trainee.merge_xml;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class MergeXmlApplication {

    public static void main(String[] args) {
        SpringApplication.run(MergeXmlApplication.class, args);
    }

}
