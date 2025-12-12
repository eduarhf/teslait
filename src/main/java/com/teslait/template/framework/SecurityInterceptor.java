package com.teslait.template.framework;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Generated;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

@Service
@Generated
@Slf4j
public class SecurityInterceptor implements WebRequestInterceptor {
    @Autowired
    private UrlExcludedConfig urlExcludedConfig;
    @Override
    public void preHandle(WebRequest handler) throws Exception {
        log.info("SecurityInterceptor: preHandle");
        if(handler instanceof NativeWebRequest){
            log.info("SecurityInterceptor: preHandle - NativeWebRequest detected");
            HttpServletRequest request = ((NativeWebRequest) handler).getNativeRequest(HttpServletRequest.class);
            log.info("INSTANCE urlExcludedConfig "+urlExcludedConfig.getUrls());
        }
    }

    @Override
    public void postHandle(WebRequest request, ModelMap model) throws Exception {
        log.info("SecurityInterceptor: postHandle");

        model.addAllAttributes(model);
    }

    @Override
    public void afterCompletion(WebRequest request, Exception ex) throws Exception {
        log.info("SecurityInterceptor: afterCompletion");
    }
}
