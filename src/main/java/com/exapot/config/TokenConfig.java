package com.exapot.config;

import com.exapot.service.TokenService;
import com.exapot.service.TokenServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Ehsaniara
 * From https://www.exapot.com
 */
@Configuration
public class TokenConfig {

    @Bean
    public TokenService tokenService() {
        return new TokenServiceImpl();
    }
}
