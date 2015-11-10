package init;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import base.configuration.ApplicationConfig;
import base.configuration.DatabaseConfig;
import base.configuration.WebConfig;


@EnableAutoConfiguration
public class WebAppInitializer implements WebApplicationInitializer {

    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
//        ctx.register(ApplicationConfig.class);
//        ctx.register(WebConfig.class);
//        ctx.register(DatabaseConfig.class);
        ctx.scan("base");
        ctx.setServletContext(servletContext);

        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
        servlet.addMapping("/rest/*");
        servlet.setLoadOnStartup(1);

    }

}
