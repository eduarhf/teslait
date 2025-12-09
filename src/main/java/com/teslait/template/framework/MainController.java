package com.teslait.template.framework;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.UUID;
@Slf4j
public class MainController {

    protected void logEntry(final UUID txRef, final ChannelEnum channel, final CountryEnum country){
        log.info("txRef [{}], channel [{}], country [{}]", txRef, channel.code(), country.code());
    }
    protected MultiValueMap<String, String> create(){
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return headers;
    }
}
