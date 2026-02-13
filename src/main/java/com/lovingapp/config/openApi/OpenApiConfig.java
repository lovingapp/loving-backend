package com.lovingapp.config.openApi;

import java.util.List;

import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lovingapp.auth.CurrentUser;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenApiConfig {

    @Value("${server.servlet.context-path:}")
    private String apiBasePath;

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .servers(List.of(new Server().url(apiBasePath)));
    }

    @Bean
    public OperationCustomizer hideCurrentUserParameter() {
        return (operation, handlerMethod) -> {

            var methodParameters = handlerMethod.getMethodParameters();

            if (operation.getParameters() == null) {
                return operation;
            }

            for (int i = methodParameters.length - 1; i >= 0; i--) {
                if (methodParameters[i].hasParameterAnnotation(CurrentUser.class)) {
                    if (i < operation.getParameters().size()) {
                        operation.getParameters().remove(i);
                    }
                }
            }

            return operation;
        };
    }
}
