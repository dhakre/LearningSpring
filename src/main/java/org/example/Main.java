package org.example;

import org.example.services.SubjectService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) throws StringEmptyException {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
        SubjectService subjectService= applicationContext.getBean(SubjectService.class);

        System.out.println(subjectService.helloWorld());
    }
}