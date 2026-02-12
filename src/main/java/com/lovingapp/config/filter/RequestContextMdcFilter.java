package com.lovingapp.config.filter;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.MDC;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.lovingapp.constants.LogContextConstants;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class RequestContextMdcFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain) throws ServletException, IOException {

        String correlationId = resolveHeader(request, LogContextConstants.Headers.CORRELATION_ID)
                .orElse(null);

        String requestId = UUID.randomUUID().toString();

        MDC.put(LogContextConstants.MdcKeys.REQUEST_ID, requestId);
        if (correlationId != null && !correlationId.isBlank()) {
            MDC.put(LogContextConstants.MdcKeys.CORRELATION_ID, correlationId);
        }

        try {
            filterChain.doFilter(request, response);
        } finally {
            MDC.remove(LogContextConstants.MdcKeys.REQUEST_ID);
            MDC.remove(LogContextConstants.MdcKeys.CORRELATION_ID);
        }
    }

    private static Optional<String> resolveHeader(HttpServletRequest request, String headerName) {
        String value = request.getHeader(headerName);
        if (value == null || value.isBlank()) {
            return Optional.empty();
        }
        return Optional.of(value);
    }
}
