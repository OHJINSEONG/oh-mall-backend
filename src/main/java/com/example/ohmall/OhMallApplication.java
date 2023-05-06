package com.example.ohmall;

import com.example.ohmall.interceptors.AuthenticationInterceptor;
import com.example.ohmall.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class OhMallApplication {
	@Value("${jwt.secret}")
	private String jwtSecret;

	public static void main(String[] args) {
		SpringApplication.run(OhMallApplication.class, args);
	}
	//http://localhost:8000/h2-console
	//http://localhost:8000/swagger-ui/

	@Bean
	public WebSecurityCustomizer ignoringCustomizer() {
		return (web) -> web.ignoring().antMatchers("/**");
	}

	@Bean
	public WebMvcConfigurer webMvcConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
			}

			@Override
			public void addInterceptors(InterceptorRegistry registry) {
				registry.addInterceptor(authenticationInterceptor());
			}
		};
	}

	@Bean
	public AuthenticationInterceptor authenticationInterceptor() {
		return new AuthenticationInterceptor(jwtUtil());
	}

	@Bean
	public JwtUtil jwtUtil() {
		return new JwtUtil(jwtSecret);
	}
}
