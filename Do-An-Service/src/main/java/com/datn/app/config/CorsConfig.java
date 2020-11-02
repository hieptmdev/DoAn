package com.datn.app.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig extends CorsFilter {
    public CorsConfig(CorsConfigurationSource configSource) {
        super(configSource);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse rep, FilterChain chain) throws ServletException, IOException {
        rep.setHeader("Access-Control-Allow-Origin", "*");
        rep.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
        rep.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type");
        rep.setHeader("Access-Control-Max-Age", "3600");
        if (HttpMethod.OPTIONS.name().equalsIgnoreCase(req.getMethod())) {
            rep.setStatus(HttpServletResponse.SC_OK);
        } else {
            chain.doFilter(req, rep);
        }
    }
}