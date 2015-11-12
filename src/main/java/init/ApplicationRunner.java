package init;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages = { "base" })
public class ApplicationRunner {
  public static void main(String[] args) {
    SpringApplication.run(new Class[] {ApplicationRunner.class}, args);
  }
}
