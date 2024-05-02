package com.example.REST.demo.DB.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@Profile("prod")
public class DataConfig {
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://10.0.2.67:1433;databaseName=TrainingDec2023;encrypt=true;trustServerCertificate=true;");
        dataSource.setUsername("sahanac");
        dataSource.setPassword("Chan@dec23");
        return dataSource;
    }
}
