package com.teslait.template.framework;

import org.springframework.context.annotation.Bean;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.web.reactive.function.client.WebClient;
import com.github.tomakehurst.wiremock.WireMockServer;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

@TestConfiguration
public class WireMockConfiguration {
    @Bean
    public WireMockServer webServer() {
        WireMockServer wireMockServer = new WireMockServer(options().dynamicPort());
        wireMockServer.start();
        return wireMockServer;
    }
    public WebClient webClient(WireMockServer wireMockServer) {
        return WebClient.builder().build();
    }
}
