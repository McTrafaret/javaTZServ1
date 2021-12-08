package com.udalny.rest;

import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CustomRestTemplateCustomizer implements RestTemplateCustomizer {
    @Override
    public void customize(RestTemplate restTemplate) {
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        restTemplate.getInterceptors().add(new CustomClientHttpInterceptor());
    }
}
