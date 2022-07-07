package pl.julka99.reportsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableScheduling
public class Main implements WebMvcConfigurer {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
}