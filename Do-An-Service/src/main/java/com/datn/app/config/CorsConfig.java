/*
package com.datn.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsConfig implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException { }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse rep = (HttpServletResponse) servletResponse;
        rep.setHeader("Access-Control-Allow-Origin", "*");
        rep.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
        rep.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type");
        rep.setHeader("Access-Control-Max-Age", "3600");
        if (HttpMethod.OPTIONS.name().equalsIgnoreCase(req.getMethod())) {
            rep.setStatus(HttpServletResponse.SC_OK);
        }
        filterChain.doFilter(req, rep);
    }

    @Override
    public void destroy() { }

    */
/*public CorsConfig(@Qualifier("corsConfigurationSource") CorsConfigurationSource configSource) {
        super(configSource);
    }*//*



    */
/*@Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse rep, FilterChain chain) throws ServletException, IOException {
        rep.setHeader("Access-Control-Allow-Origin", "*");
        rep.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
        rep.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type");
        rep.setHeader("Access-Control-Max-Age", "3600");
        if (HttpMethod.OPTIONS.name().equalsIgnoreCase(req.getMethod())) {
            rep.setStatus(HttpServletResponse.SC_OK);
        }
        chain.doFilter(req, rep);
    }*//*

}
*/
