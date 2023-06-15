package com.example.demo.testMe;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class StreetService {
    private final Animal cat;
    private final Animal dog;

    @Autowired
    public StreetService(@Qualifier("createCat") Animal cat,Animal dog) {
        this.cat = cat;
        this.dog = dog;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("post construct of street");
        this.cat.makeSound();
        this.dog.makeSound();
        System.out.println(cat.hashCode());
        System.out.println(dog.hashCode());
    }
}
