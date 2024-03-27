package com.example.demo.config;

import io.r2dbc.pool.ConnectionPool;
import io.r2dbc.pool.ConnectionPoolConfiguration;
import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import io.r2dbc.spi.Option;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;

import java.time.Duration;

import static io.r2dbc.spi.ConnectionFactoryOptions.DATABASE;
import static io.r2dbc.spi.ConnectionFactoryOptions.DRIVER;
import static io.r2dbc.spi.ConnectionFactoryOptions.HOST;
import static io.r2dbc.spi.ConnectionFactoryOptions.PASSWORD;
import static io.r2dbc.spi.ConnectionFactoryOptions.PORT;
import static io.r2dbc.spi.ConnectionFactoryOptions.USER;

@Configuration
@RequiredArgsConstructor
public class PostgresConfiguration extends AbstractR2dbcConfiguration {

    private static final String SCHEMA = "schema";

    @Override
    @Bean
    public ConnectionFactory connectionFactory() {
        ConnectionFactory connectionFactory = ConnectionFactories.get(ConnectionFactoryOptions.builder()
                .option(DRIVER, "postgresql")
                .option(HOST, "localhost")
                .option(PORT, 5432)
                .option(USER, "root")
                .option(PASSWORD, "password")
                .option(DATABASE, "root")
                .option(Option.valueOf(SCHEMA), "public")
                .build());

        ConnectionPoolConfiguration configuration = ConnectionPoolConfiguration.builder(connectionFactory)
                .maxIdleTime(Duration.ofSeconds(30))
                .initialSize(1)
                .maxSize(2)
                .minIdle(1)
                .build();

        return new ConnectionPool(configuration);
    }
}

