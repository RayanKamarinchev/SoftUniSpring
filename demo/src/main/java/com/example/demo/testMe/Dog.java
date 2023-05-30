package com.example.demo.testMe;

public class Dog implements Animal{
    public Dog() {
        makeSound();
    }
    @Override
    public void makeSound() {
        System.out.println("created Dog");
    }
}
