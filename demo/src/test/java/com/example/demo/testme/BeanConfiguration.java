package com.example.demo.testme;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class BeanConfiguration {
    @Bean(value = "dog")
    public Animal createDog(){
        return new Dog();
    }

    @Bean
    //Primary
    public Animal createCat(){
        return new Cat();
    }
}
