package prink.flight.flightapi.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // Lubab kõikidele domeenidele päringud kõigi meetoditega (GET, POST, PUT...)
    // Päris tootes peaks piirama lubatud pärinugid.

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*") // Kõik päritolud
                .allowedMethods("*") // Kõik HTTP meetodid
                .allowedHeaders("*") // Kõik HTTP päised
                .allowCredentials(false); // Ei luba küpsiste ja autentimisteabe edastamist
    }
}
