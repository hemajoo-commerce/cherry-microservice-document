/*
 * (C) Copyright Hemajoo Systems Inc.  2022 - All Rights Reserved
 * -----------------------------------------------------------------------------------------------
 * All information contained herein is, and remains the property of
 * Hemajoo Inc. and its suppliers, if any. The intellectual and technical
 * concepts contained herein are proprietary to Hemajoo Inc. and its
 * suppliers and may be covered by U.S. and Foreign Patents, patents
 * in process, and are protected by trade secret or copyright law.
 *
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained from
 * Hemajoo Systems Inc.
 * -----------------------------------------------------------------------------------------------
 */
package com.hemajoo.commerce.cherry.microservice.document.test.base;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;

/**
 * Abstract class providing PostgresSQL support for unit tests through docker container.
 * @author <a href="mailto:christophe.resse@gmail.com">Christophe Resse</a>
 * @version 1.0.0
 */
@Log4j2
public abstract class AbstractPostgresUnitTest
{
    /**
     * Docker test-container port number for <b>postgres</b>.
     */
    protected static final int POSTGRES_SQL_PORT_NUMBER = 56756;

    /**
     * PostgresSQL docker container.
     */
    @Getter
    @Container
    protected static final PostgreSQLContainer<?> POSTGRES_SQL_CONTAINER = new PostgreSQLContainer<>("postgres:latest")
            .withUsername("postgres")
            .withPassword("postgres")
            .withDatabaseName("unit-test")
            //.withEnv("AWS_REGION", "eu-west-3")
            .withReuse(true);

    /**
     * Set dynamically some properties.
     * @param registry Property registry.
     */
    @DynamicPropertySource
    private static void properties(DynamicPropertyRegistry registry)
    {
        registry.add("spring.datasource.url", POSTGRES_SQL_CONTAINER::getJdbcUrl);
        registry.add("spring.datasource.username", POSTGRES_SQL_CONTAINER::getUsername);
        registry.add("spring.datasource.password", POSTGRES_SQL_CONTAINER::getPassword);
        registry.add("spring.jpa.generate-ddl", () -> "true");
        registry.add("spring.jpa.hibernate.ddl-auto", () -> "update");
        registry.add("spring.batch.initialize-schema", () -> "always");

        LOGGER.info(String.format("Postgres container host address: %s", POSTGRES_SQL_CONTAINER.getHost()));
        LOGGER.info(String.format("Postgres container port number: %s", POSTGRES_SQL_CONTAINER.getFirstMappedPort()));
    }

//    static
//    {
//        POSTGRES_SQL_CONTAINER.start();
//    }
}
