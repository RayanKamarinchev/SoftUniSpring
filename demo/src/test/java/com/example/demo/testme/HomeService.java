package com.example.demo.testme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class HomeService {
    private final Animal dog;
    private final Animal cat;
    @Autowired
    public HomeService(Animal dog, @Qualifier("createCat") Animal cat) {
        this.dog = dog;
        this.cat = cat;
        System.out.println("At home");
        this.dog.makeSound();
        this.cat.makeSound();
    }
}
