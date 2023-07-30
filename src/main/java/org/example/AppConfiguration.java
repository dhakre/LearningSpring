package org.example;

import org.example.services.HelloService;
import org.example.services.SubjectService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfiguration {

    @Value("${app.name}")
    String name;
    @Bean
    HelloService helloService(){
        return new HelloService();
    }
    @Bean
    SubjectService subjectService(){
        return new SubjectService(name,helloService());

    }
}
