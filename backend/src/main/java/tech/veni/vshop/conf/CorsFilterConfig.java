package tech.veni.vshop.conf;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsFilterConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*") // 允许的跨域请求来源
                .allowedMethods("*") // 允许的HTTP方法
                .allowedHeaders("*"); // 允许的请求头信息
    }
}
