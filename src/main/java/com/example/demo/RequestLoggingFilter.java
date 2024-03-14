package com.example.demo;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class RequestLoggingFilter extends OncePerRequestFilter{

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Логируем данные запроса
        System.out.println("Endpoint: " + request.getRequestURI());
        System.out.println("Address: " + request.getRemoteAddr());
        System.out.println("User-Agent: " + request.getHeader("User-Agent"));

        // Пропускаем запрос к следующему фильтру в цепочке
        filterChain.doFilter(request, response);
    }
}
