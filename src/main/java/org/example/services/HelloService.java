package org.example.services;

import org.example.aop.CountMethodCalls;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public HelloService() {
    }

    @CountMethodCalls
    public String outputHello(){
        return "Hello ";
    }
}
