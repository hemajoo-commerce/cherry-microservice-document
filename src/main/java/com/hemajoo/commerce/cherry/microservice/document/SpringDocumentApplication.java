package com.hemajoo.commerce.cherry.microservice.document;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

/**
 * Spring boot application for the <b>document microservice</b>.
 * @author <a href="mailto:christophe.resse@gmail.com">Christophe Resse</a>
 * @version 1.0.0
 */
@Log4j2
//@Import({ PersistenceConfiguration.class })
@SpringBootApplication//(exclude = { S3ContentAutoConfiguration.class })
public class SpringDocumentApplication implements CommandLineRunner
{
    @Autowired
    private ApplicationContext applicationContext;

    /**
     * Returns the <b>OpenAPI</b> information.
     * @return <b>OpenAPI</b> information.
     */
    @Bean
    public OpenAPI openApi()
    {
        return new OpenAPI()
                .info(new Info().title("Cherry Backend - REST-APIs")
                        .description("Hemajoo's Cherry Backend REST-API controllers")
                        .version("0.1.0")
                        .license(new License().name("Hemajoo (c) 2022 - All rights reserved").url("https://github.com/ressec/cherry-backend")))
                .externalDocs(new ExternalDocumentation()
                        .description("Cherry Backend Wiki Documentation")
                        .url("https://github.com/ressec/cherry-backend"));
    }

    /**
     * Main application entry point.
     * @param args Arguments.
     */
    public static void main(String[] args)
    {
        new SpringApplicationBuilder(SpringDocumentApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }

    @Override
    public void run(String... args) throws Exception
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
}
