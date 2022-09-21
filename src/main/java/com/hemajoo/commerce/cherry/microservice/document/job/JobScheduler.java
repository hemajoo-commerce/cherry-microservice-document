package com.hemajoo.commerce.cherry.microservice.document.job;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Document microservice task scheduler.
 * @author <a href="mailto:christophe.resse@kyndryl.com">Christophe Resse</a>
 * @version 1.0.0
 */
@Log4j2
@Configuration
@EnableScheduling
public class JobScheduler
{
    /**
     * CRON expression.
     */
    @Value("${ENV_EAL_CRON_EXPRESSION}") // Loading a value from an environment variable.
    private String cron;

    @Scheduled(cron = "*/10 * * * * *")
    public final void heartBeat()
    {
        LOGGER.info("'heartBeat' scheduled task invoked.");
    }
}
