package kr.eddi.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(
                        "http://127.0.0.1:8080",
                        "http://localhost:8080",
                        "http://3.38.61.219",           // 다운
                        "http://3.27.140.38",           // 재경
                        "http://15.164.236.162",        // 지원
                        "http://43.201.152.175",        // 진호
                        "http://15.164.237.78")         // 유진
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}
