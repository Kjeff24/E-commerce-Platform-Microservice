package com.bexos.order_service.config;

import com.bexos.order_service.dto.OrderItemRequest;
import com.bexos.order_service.dto.OrderRequest;
import com.bexos.order_service.model.Order;
import com.bexos.order_service.model.OrderItem;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public ModelMapper getModelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // ModelMapper attempted to map userId from OrderRequest to id in Order
        // ModelMapper attempted to map productId from OrderItemRequest to id in OrderItem
        // In order to prevent it, set the configuration below to strictly match property names during mapping.
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);

        return modelMapper;
    }
}
