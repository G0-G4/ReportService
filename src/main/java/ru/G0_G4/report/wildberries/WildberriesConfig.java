package ru.G0_G4.report.wildberries;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WildberriesConfig {

  @Value("${report.wildberries.token}")
  private String token;
  @Value("${report.test}")
  private boolean test;

  @Bean
  public WildberriesClient getClient() {
    return new WildberriesClient(token, test);
  }
}
