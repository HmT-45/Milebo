package com.example.milebo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.Connection;

@Slf4j
@Configuration
public class StartupConfig {
//để check kết nối sql server
    @Bean
    ApplicationRunner logDatabaseConnection(DataSource dataSource) {
        return args -> {
            try (Connection conn = dataSource.getConnection()) {
                log.info("Ket noi DB thanh cong");
                log.info("DB URL: {}", conn.getMetaData().getURL());
                log.info("DB User: {}", conn.getMetaData().getUserName());
            }
        };
    }
}
