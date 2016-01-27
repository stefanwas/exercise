package init;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;

@EnableAutoConfiguration
@ComponentScan(basePackages = { "base" })
public class ApplicationRunner {
  public static void main(String[] args) {
    SpringApplication.run(new Class[] {ApplicationRunner.class}, args);
  }

}
