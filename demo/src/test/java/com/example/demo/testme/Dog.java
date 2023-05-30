package com.example.demo.testme;

public class Dog implements Animal{

    public Dog() {
        makeSound();
    }

    @Override
    public void makeSound() {
        System.out.println("bark");
    }
}
