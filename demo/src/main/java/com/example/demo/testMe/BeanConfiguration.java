package com.example.demo.testMe;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean(value = "dog")
    //@Primary
    //@Scope("prototype")
    public Animal createDog() {
        return new Dog();
    }

    @Bean
    public Animal createCat() {
        return new Cat();
    }
}
