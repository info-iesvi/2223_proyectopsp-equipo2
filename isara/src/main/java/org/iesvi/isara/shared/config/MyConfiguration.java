package org.iesvi.isara.shared.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The goal of ModelMapper is to make object mapping easy, by automatically determining how one object model maps
 * to another, based on conventions, in the same way that a human would - while providing a simple, refactoring-safe API
 * for handling specific use cases.
 *
 * @author Isa & Sara
 */
@Configuration
public class MyConfiguration {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
