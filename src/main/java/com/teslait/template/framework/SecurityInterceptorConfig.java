package com.teslait.template.framework;

import lombok.Generated;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Slf4j
@Configuration
@Generated

public class SecurityInterceptorConfig extends WebMvcConfigurationSupport {

    @Bean
    SecurityInterceptor securityInterceptor() {
        return new SecurityInterceptor();
    }

    @Override
    protected void addInterceptors(org.springframework.web.servlet.config.annotation.InterceptorRegistry registry) {
        registry.addWebRequestInterceptor(securityInterceptor());
    }
}
