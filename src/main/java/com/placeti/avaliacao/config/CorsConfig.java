package com.placeti.avaliacao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:4200"); // Permite requisições de localhost:4200
        config.addAllowedHeader("*"); // Permite todos os cabeçalhos
        config.addAllowedMethod("*"); // Permite todos os métodos (GET, POST, PUT, DELETE, etc.)
        source.registerCorsConfiguration("/**", config); // Aplica a configuração a todas as rotas
        return new CorsFilter(source);
    }
}
