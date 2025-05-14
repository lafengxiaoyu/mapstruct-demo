package org.example.config;

import org.example.mapper.OrderMapStructMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public OrderMapStructMapper orderMapper() {
        return Mappers.getMapper(OrderMapStructMapper.class);
    }
}