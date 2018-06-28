package com.authority.autoconfigure;

import com.authority.controller.SecurityController;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by merit on 2018/2/5.
 */
@Configuration
public class AuthorityAutoConfigure {
    @Bean
    @ConditionalOnMissingBean(SecurityController.class)
    SecurityController securityController() {
        return new SecurityController();
    }
}
