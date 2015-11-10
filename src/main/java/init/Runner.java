package init;

import org.springframework.boot.SpringApplication;

import base.configuration.ApplicationConfig;
import base.configuration.WebConfig;

public class Runner {
  public static void main(String[] args) {
    SpringApplication.run(new Class[] {WebAppInitializer.class}, args);
  }
}
