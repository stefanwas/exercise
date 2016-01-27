package init;

import base.configuration.WebConfig;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * This class is used by embedded maven tomcat to initialize web application.
 */
public class ApplicationInitializer implements WebApplicationInitializer {

    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.scan("base");
        ctx.setServletContext(servletContext);

        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcherServlet", new DispatcherServlet(ctx));
        servlet.addMapping("/rest/*");
        servlet.setLoadOnStartup(1);
    }

}
