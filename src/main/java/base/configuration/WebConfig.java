package base.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Configuration - this annotation indicates a class that plays the same role as xml file containing bean definitions.
 *
 * @EnableWebMvc - this annotation imports the Spring MVC configuration from {@link WebMvcConfigurationSupport}.
 * To customize the imported configuration, implement the interface {@link WebMvcConfigurer} or more likely extend the empty method
 * of the base class {@link WebMvcConfigurerAdapter} and override individual methods.
 */
@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {
  /*
   * In Spring MVC requested content type is determined in the following order:
   *
   * 1. file extension like this: (default on)
   * http://myserver/myapp/mydata/list.html -> will map into html content-type
   *
   * 2. URL parameter like this: (default off)
   * http://myserver/myapp/mydata/list?format=xls
   * The name of the parameter is format by default, but this may be changed.
   *
   * 3. 'Accept' HTTP header like this: (default off)
   * Accept: application/json
   *
   * The order cannot be changed. Single steps can only be turned on and off.
   */
  @Override
  public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
    configurer.favorPathExtension(false);
    configurer.favorParameter(true);
    configurer.ignoreAcceptHeader(false);
    configurer.defaultContentType(MediaType.APPLICATION_JSON);

    // below properties have effect when request param strategy is used
    configurer.parameterName("mediaType");
    configurer.mediaType("xml", MediaType.APPLICATION_XML);
    configurer.mediaType("json", MediaType.APPLICATION_JSON);
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/**").addResourceLocations("/");
  }
}
