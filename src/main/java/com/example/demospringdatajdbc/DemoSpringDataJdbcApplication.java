package com.example.demospringdatajdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication
@EnableJdbcRepositories
public class DemoSpringDataJdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringDataJdbcApplication.class, args);
    }
}
