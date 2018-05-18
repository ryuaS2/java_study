package com.ubivelox.tlv.config;

import java.nio.charset.Charset;

import javax.servlet.Filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
	registry.addViewController("/").setViewName("index");
	registry.addViewController("/error").setViewName("error");
    };

    /*
     * responseBodyConverter는 결과를 출력시에 강제로 UTF-8로 설정하는 역할을 하며
     * characterEncodingFilter는 POST 요청시에 한글이 깨지는 문제를 보완
     */
    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
	return new StringHttpMessageConverter(Charset.forName("UTF-8"));
    }

    @Bean
    public Filter characterEncodingFilter() {
	CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
	characterEncodingFilter.setEncoding("UTF-8");
	characterEncodingFilter.setForceEncoding(true);
	return characterEncodingFilter;
    }

    @Override
    public void addInterceptors(final InterceptorRegistry registry) {
	registry.addInterceptor(new DomainInterceptor());
    }
}
