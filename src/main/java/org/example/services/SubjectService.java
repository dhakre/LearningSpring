package org.example.services;

public class SubjectService {
    private String name;
    private HelloService helloService;

    public SubjectService(String name, HelloService helloService) {
        this.name = name;
        this.helloService = helloService;
    }

    public void helloWorld(){
        System.out.print("\t"+ this.name);
    }
}
