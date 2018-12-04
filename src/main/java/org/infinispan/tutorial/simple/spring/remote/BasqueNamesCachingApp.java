package org.infinispan.tutorial.simple.spring.remote;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class BasqueNamesCachingApp {

   public static void main(String... args) {
      new SpringApplicationBuilder().sources(BasqueNamesCachingApp.class).run(args);
   }
}
