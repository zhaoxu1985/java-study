package org.zhaoxu.springstudy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 对所有接口路径生效
        registry.addMapping("/**")
                // 允许所有来源（本地开发用，生产环境需改为具体域名）
                .allowedOriginPatterns("*")
                // 允许所有请求方法（GET/POST/PUT/DELETE 等）
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                // 允许所有请求头
                .allowedHeaders("*")
                // 允许携带 Cookie（如果需要登录态）
                .allowCredentials(true)
                // 预检请求有效期（秒）
                .maxAge(3600);
    }
}