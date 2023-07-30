package org.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {
    @Value("${app.name}")
    private String name;
    private HelloService helloService;
    @Autowired
    public SubjectService( HelloService helloService) {
        this.helloService = helloService;
    }

    public void helloWorld(){
        System.out.print("\t"+ this.name);
    }
}
