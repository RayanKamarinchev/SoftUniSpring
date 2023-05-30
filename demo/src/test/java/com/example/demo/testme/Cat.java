package com.example.demo.testme;

public class Cat implements Animal {

    public Cat() {
        makeSound();
    }

    @Override
    public void makeSound() {
        System.out.println("meow");
    }
}
