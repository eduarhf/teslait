package com.teslait.template.framework;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Generated;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

import java.util.Collections;
import java.util.Iterator;

@Service
@Generated
@Slf4j
public class SecurityInterceptor implements WebRequestInterceptor {
    @Autowired
    private UrlExcludedConfig urlExcludedConfig;
    @Autowired
    private HttpServletRequest request;

    @Override
    public void preHandle(WebRequest handler) throws Exception {
        log.info("SecurityInterceptor: preHandle");
        CountryEnum countryEnum = CountryEnum.valueOf(request.getHeader("country"));
        log.info("Country from header: " + countryEnum.code());
        if (handler instanceof NativeWebRequest) {
            log.info("SecurityInterceptor: preHandle - NativeWebRequest detected");
            HttpServletRequest request = ((NativeWebRequest) handler).getNativeRequest(HttpServletRequest.class);
            log.info("INSTANCE urlExcludedConfig " + urlExcludedConfig.getUrls());
        }
        log.info("UserPrincipal: " + handler.getUserPrincipal());
        for (Iterator<String> it = handler.getHeaderNames(); it.hasNext(); ) {
            String name = it.next();
            log.info("Header: {} = {}", name, handler.getHeader(name));
        }
    }
            @Override
            public void postHandle (WebRequest request, ModelMap model) throws Exception {
                log.info("SecurityInterceptor: postHandle");

            }

            @Override
            public void afterCompletion (WebRequest request, Exception ex) throws Exception {
                log.info("SecurityInterceptor: afterCompletion");
            }
        }
