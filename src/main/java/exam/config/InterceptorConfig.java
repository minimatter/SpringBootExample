package exam.config;

import exam.interceptor.AuthenticationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    public HandlerInterceptor  authenticationInterceptor(){
        return  new AuthenticationInterceptor();
    }

    /**
     * 是资源不被拦截
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("/classpath:/static/**");


        WebMvcConfigurer.super.addResourceHandlers(registry);

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor())

                //拦截所有
                .addPathPatterns("/**")
                //加入白名单
                .excludePathPatterns("/Login/login")
                .excludePathPatterns("/Login/signIn")
                .excludePathPatterns("/**/*.css","/**/*.js", "/**/*.png", "/**/*.jpg",
                        "/**/*.jpeg", "/**/*.gif", "/**/fonts/*","/static/**");


        WebMvcConfigurer.super.addInterceptors(registry);

    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("/Login/login");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);

        WebMvcConfigurer.super.addViewControllers(registry);
    }
}
