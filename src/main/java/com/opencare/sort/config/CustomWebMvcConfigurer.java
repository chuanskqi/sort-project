package com.opencare.sort.config;

import static com.fasterxml.jackson.databind.DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS;
import static com.fasterxml.jackson.databind.DeserializationFeature.USE_LONG_FOR_INTS;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * {@link https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-config-message-converters}
 */
@Configuration
@EnableWebMvc
public class CustomWebMvcConfigurer implements WebMvcConfigurer{

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        ObjectMapper objectMapper = new ObjectMapper();
        // 统一把   int 转 long
        objectMapper.configure(USE_LONG_FOR_INTS, true);
        // 统一把 float 转 bigdecimal
        objectMapper.configure(USE_BIG_DECIMAL_FOR_FLOATS, true);
        converters.add(new MappingJackson2HttpMessageConverter(objectMapper));
    }
}
