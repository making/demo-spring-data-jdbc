package com.example.demospringdatajdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jdbc.core.DataAccessStrategy;
import org.springframework.data.jdbc.core.DefaultDataAccessStrategy;
import org.springframework.data.jdbc.core.DelegatingDataAccessStrategy;
import org.springframework.data.jdbc.core.SqlGeneratorSource;
import org.springframework.data.jdbc.mapping.model.JdbcMappingContext;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
@EnableJdbcRepositories
public class DemoSpringDataJdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringDataJdbcApplication.class, args);
    }

    // temporary workaround for https://jira.spring.io/browse/DATAJDBC-155
    @Bean
    DataAccessStrategy defaultDataAccessStrategy(JdbcMappingContext context, DataSource dataSource) {
        NamedParameterJdbcOperations operations = new NamedParameterJdbcTemplate(dataSource);
        DelegatingDataAccessStrategy accessStrategy = new DelegatingDataAccessStrategy();
        accessStrategy.setDelegate(new DefaultDataAccessStrategy( //
                new SqlGeneratorSource(context), //
                operations, //
                context, //
                accessStrategy) //
        );
        return accessStrategy;
    }
}
