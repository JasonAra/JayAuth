package com.exapot.config;

import com.exapot.service.TokenService;
import com.exapot.service.TokenServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Jason Ara (Jay.Ara) on 7/11/17.
 * From https://www.exapot.com
 */
@Configuration
public class TokenConfig {

    @Bean
    public TokenService tokenService() {
        return new TokenServiceImpl();
    }
}
