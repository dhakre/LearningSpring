package org.example;

import org.example.services.HelloService;
import org.example.services.SubjectService;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfiguration {

    @Bean
    public HelloService helloService(){
        return new HelloService();
    }

    @Bean
    @Profile("dev")
    public SubjectService subjectService(HelloService helloService){
        return new SubjectService(helloService,"World");
    }
    @Bean
    @Profile("prod")
    public SubjectService subjectService2(HelloService helloService){
        return new SubjectService(helloService,"Saturn");
    }

}
