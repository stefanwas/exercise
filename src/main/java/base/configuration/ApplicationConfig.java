package base.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.xml.MarshallingView;

import java.util.Arrays;

import javax.servlet.ServletContext;


/**
 * @Configuration - this annotation indicates a class that plays the same role as xml file containing bean definitions.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "base" })
public class ApplicationConfig {

    /*
     * In Spring MVC requested content type is determined in the following order:
     *
     * 1. file extension like this:
     * http://myserver/myapp/mydata/list.html -> will map into html content-type
     *
     * 2. URL parameter like this:
     * http://myserver/myapp/mydata/list?format=xls
     * The name of the parameter is format by default, but this may be changed.
     *
     * 3. 'Accept' HTTP header
     * Accept: application/json
     */

    //dziala + extends WebMvcConfigurerAdapter
    //https://spring.io/blog/2013/05/11/content-negotiation-using-spring-mvc
//    @Override
//    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//        configurer.favorPathExtension(false).
//            favorParameter(true).
//            parameterName("mediaType").
//            ignoreAcceptHeader(true).
//            useJaf(false).
//            defaultContentType(MediaType.APPLICATION_XML).
//            mediaType("xml", MediaType.APPLICATION_XML).
//            mediaType("json", MediaType.APPLICATION_JSON);
//    }

//    @Bean
//    public ContentNegotiatingViewResolver contentViewResolver() throws Exception {
//        MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
//        jsonView.setContentType("application/json");
//
////        MarshallingView xmlView = new MarshallingView();
////        xmlView.setContentType("application/xml");
//
//        ContentNegotiatingViewResolver contentViewResolver = new ContentNegotiatingViewResolver();
//        contentViewResolver.setDefaultViews(Arrays.<View>asList(jsonView));
//        return contentViewResolver;
//    }


    // nie dziala
    @Bean
    public ContentNegotiationConfigurer contentNegotiationConfigurer(ServletContext servletContext) throws Exception {
        ContentNegotiationConfigurer configurer = new ContentNegotiationConfigurer(servletContext);

        configurer.favorPathExtension(false);
        configurer.favorParameter(true);
        configurer.parameterName("mediaType").
        ignoreAcceptHeader(true).
            defaultContentType(MediaType.APPLICATION_JSON).
            mediaType("xml", MediaType.APPLICATION_XML).
            mediaType("json", MediaType.APPLICATION_JSON);
        return configurer;
    }

}