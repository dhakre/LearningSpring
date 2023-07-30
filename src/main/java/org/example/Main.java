package org.example;

import org.example.services.SubjectService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

//        HelloService helloService = new HelloService();
//        SubjectService subjectService = new SubjectService("World", helloService);
//
//        subjectService.helloWorld();
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
        SubjectService subjectService= applicationContext.getBean(SubjectService.class);

        subjectService.helloWorld();
    }
}