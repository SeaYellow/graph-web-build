package com.actuator.autoconfigure;

import com.actuator.controller.ActuatorController;
import com.actuator.controller.ActuatorRestController;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by merit on 2018/2/5.
 */
@Configuration
public class ActuatorAutoConfigure {

    @Bean
    @ConditionalOnMissingBean(ActuatorController.class)
    ActuatorController actuatorController() {
        return new ActuatorController();
    }

    @Bean
    @ConditionalOnMissingBean(ActuatorRestController.class)
    ActuatorRestController actuatorRestController() {
        return new ActuatorRestController();
    }
}
