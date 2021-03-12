package com.blog.api.config.springdoc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.UnknownHostException;

@Configuration
@RequiredArgsConstructor
public class OpenApiConfig {

  @Bean
  public OpenAPI setOpenAPI() throws UnknownHostException {

    OpenAPI openAPI = new OpenAPI().info(new Info().title("blog API").description("blog API"));

    return openAPI;
  }
}
