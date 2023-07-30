package org.example.services;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public HelloService() {
        System.out.print("Hello ");
    }
}
