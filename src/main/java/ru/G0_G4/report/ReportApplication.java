package ru.G0_G4.report;

import io.micrometer.core.instrument.binder.MeterBinder;
import io.micrometer.core.instrument.Counter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReportApplication {

  public static void main(String[] args) {
    SpringApplication.run(ReportApplication.class, args);
  }

  @Bean
  MeterBinder meterBinder() {
    return registry -> {
      Counter.builder("counter").register(registry);
    };
  }

}
