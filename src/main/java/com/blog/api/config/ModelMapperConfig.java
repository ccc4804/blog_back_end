package com.blog.api.config;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

  @Bean
  public ModelMapper modelMapper() {
    ModelMapper modelMapper = new ModelMapper();
    // 연결 전략을 STRICT로 설정
    modelMapper
        .getConfiguration()
        .setDeepCopyEnabled(true)
        .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
        .setMatchingStrategy(MatchingStrategies.STRICT)
        .setPropertyCondition(Conditions.isNotNull());
    return modelMapper;
  }
}
