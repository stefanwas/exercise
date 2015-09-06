package exercise.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.Arrays;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "exercise.*" })
public class ApplicationConfig {

    @Bean
    public ContentNegotiatingViewResolver contentViewResolver() throws Exception {
        MappingJackson2JsonView defaultView = new MappingJackson2JsonView();
        defaultView.setExtractValueFromSingleKeyModel(true);

        ContentNegotiatingViewResolver contentViewResolver = new ContentNegotiatingViewResolver();
        contentViewResolver.setDefaultViews(Arrays.<View>asList(defaultView));
        return contentViewResolver;
    }

    @Bean
    public MappingJackson2HttpMessageConverter jacksonMessageConverter() {
        return new MappingJackson2HttpMessageConverter();
    }
}