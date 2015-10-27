package base.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.xml.MarshallingView;

import java.util.Arrays;

import javax.servlet.ServletContext;


/**
 *
 * @Configuration - this annotation indicates a class that plays the same role as xml file containing bean definitions.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "base" })
public class ApplicationConfig {

    @Bean
    public ContentNegotiatingViewResolver contentViewResolver() throws Exception {
        MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
        jsonView.setContentType("application/json");

        MarshallingView xmlView = new MarshallingView();
        xmlView.setContentType("application/xml");

        ContentNegotiatingViewResolver contentViewResolver = new ContentNegotiatingViewResolver();
        contentViewResolver.setDefaultViews(Arrays.<View>asList(jsonView, xmlView));
        return contentViewResolver;
    }

    @Bean
    public ContentNegotiationConfigurer contentNegotiationConfigurer(ServletContext servletContext) throws Exception {
        ContentNegotiationConfigurer configurer = new ContentNegotiationConfigurer(servletContext);

        configurer.favorPathExtension(false);
        configurer.favorParameter(true).
//                parameterName("mediaType").
    ignoreAcceptHeader(false).
            useJaf(false).
            defaultContentType(MediaType.APPLICATION_JSON).
            mediaType("xml", MediaType.APPLICATION_XML).
            mediaType("json", MediaType.APPLICATION_JSON);
        return configurer;
    }

}