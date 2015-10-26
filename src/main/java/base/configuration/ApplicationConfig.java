package base.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.xml.MarshallingView;

import java.util.Arrays;


/**
 *
 * @Configuration - plays the same role as xml file containing bean definitions.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "base" })
public class ApplicationConfig {

    @Bean
    public ContentNegotiatingViewResolver contentViewResolver() throws Exception {
        MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
        jsonView.setContentType("application/json");
//        jsonView.setExtractValueFromSingleKeyModel(true);

        MarshallingView xmlView = new MarshallingView();
        xmlView.setContentType("application/xml");

        ContentNegotiatingViewResolver contentViewResolver = new ContentNegotiatingViewResolver();
        contentViewResolver.setDefaultViews(Arrays.<View>asList(jsonView, xmlView));
        return contentViewResolver;
    }

    @Bean
    public MappingJackson2HttpMessageConverter jacksonMessageConverter() {
        return new MappingJackson2HttpMessageConverter();
    }
}