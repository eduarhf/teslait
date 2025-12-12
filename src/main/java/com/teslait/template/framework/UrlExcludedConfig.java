package com.teslait.template.framework;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import lombok.Generated;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

import java.util.Arrays;
import java.util.List;

@Slf4j
//@Data
@Component
public class UrlExcludedConfig {

    private final List<String> urls;

    public UrlExcludedConfig(@Value("${endpoids.excluded}") String urlsToExclude) {
        log.info("UrlExcludedConfig : constructor"+urlsToExclude);
        this.urls = Arrays.asList(urlsToExclude.split(","));
    }
    public List<String> getUrls() {
        log.info("UrlExcludedConfig : getUrls");
        return urls;
    }
}
