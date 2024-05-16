package com.mateusjose98.dummyapp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class DummyAppApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DummyAppApplication.class, args);
    }
    @Autowired
    private CacheService<ProductAttr> cacheService;


    @Override
    public void run(String... args) throws Exception {
        System.out.println("Application started!");
        System.out.println("Application started!");
        System.out.println("Application started!");
        System.out.println("Application started!");
        ProductAttr teste = new ProductAttr();
        teste.setName("teste");
        teste.setValue("teste");
        cacheService.save("1", teste);

        System.out.println("Cache size: " + cacheService.get("1"));


    }
}
