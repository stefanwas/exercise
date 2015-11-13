package init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = { "base" })
@EnableAutoConfiguration
public class Runner {
  public static void main(String[] args) {
    SpringApplication.run(new Class[] {Runner.class}, args);
  }
}
