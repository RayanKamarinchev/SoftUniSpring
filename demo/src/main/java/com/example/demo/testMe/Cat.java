package com.example.demo.testMe;

public class Cat  implements Animal{
    public Cat() {
        makeSound();
    }

    @Override
    public void makeSound() {
        System.out.println("created Cat");
    }
}
