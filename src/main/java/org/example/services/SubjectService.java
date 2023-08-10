package org.example.services;

import org.example.StringEmptyException;
import org.example.aop.CountMethodCalls;
import org.example.aop.Logging;
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
    @Logging
    @CountMethodCalls
    public String helloWorld() throws StringEmptyException {
        if(name.isEmpty()){
            throw new StringEmptyException("String is empty");
        }
        return helloService.outputHello() + name;
    }
}
