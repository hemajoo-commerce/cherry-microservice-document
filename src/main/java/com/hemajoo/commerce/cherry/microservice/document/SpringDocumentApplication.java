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
package com.hemajoo.commerce.cherry.microservice.document;

import com.hemajoo.commerce.cherry.microservice.document.rest.controller.DocumentController;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

/**
 * Spring boot application for the <b>document microservice</b>.
 * @author <a href="mailto:christophe.resse@gmail.com">Christophe Resse</a>
 * @version 1.0.0
 */
@Log4j2
//@Import({ PersistenceConfiguration.class })
@ComponentScan(basePackageClasses = { DocumentController.class })
@SpringBootApplication//(exclude = { S3ContentAutoConfiguration.class })
public class SpringDocumentApplication
{
    @Autowired
    private ApplicationContext applicationContext;

    /**
     * API title.
     */
    @Value("${hemajoo.commerce.cherry.microservice.document.openapi.title}")
    private String apiTitle;

    /**
     * API description.
     */
    @Value("${hemajoo.commerce.cherry.microservice.document.openapi.description}")
    private String apiDescription;

    /**
     * API version.
     */
    @Value("${hemajoo.commerce.cherry.microservice.document.openapi.version}")
    private String apiVersion;

    /**
     * API license name.
     */
    @Value("${hemajoo.commerce.cherry.microservice.document.openapi.license.name}")
    private String apiLicenseName;

    /**
     * API license url.
     */
    @Value("${hemajoo.commerce.cherry.microservice.document.openapi.license.url}")
    private String apiLicenseUrl;

    /**
     * API external documentation description.
     */
    @Value("${hemajoo.commerce.cherry.microservice.document.openapi.external.description}")
    private String apiExternalDescription;

    /**
     * API external documentation url.
     */
    @Value("${hemajoo.commerce.cherry.microservice.document.openapi.external.url}")
    private String apiExternalUrl;

    /**
     * Returns the <b>OpenAPI</b> information.
     * @return <b>OpenAPI</b> information.
     */
    @Bean
    public OpenAPI openApi()
    {
        return new OpenAPI()
                .info(new Info().title(apiTitle)
                        .description(apiDescription)
                        .version(apiVersion)
                        .license(new License()
                                .name(apiLicenseName)
                                .url(apiLicenseUrl)))
                .externalDocs(new ExternalDocumentation()
                        .description(apiExternalDescription)
                        .url(apiExternalUrl));
    }

    /**
     * Dump the Spring beans.
     */
    @Bean
    public void dumpBeans()
    {
        int index = 1;
        String[] beans = applicationContext.getBeanDefinitionNames();
        Arrays.sort(beans);

        LOGGER.debug(String.format("%s beans loaded...", beans.length));
        for (String bean : beans)
        {
            LOGGER.debug(String.format("# %s: %s", index, bean));
            index++;
        }
    }

    /**
     * Main application entry point.
     * @param args Arguments.
     */
    public static void main(String[] args)
    {
        SpringApplication.run(SpringDocumentApplication.class, args);
    }
}
