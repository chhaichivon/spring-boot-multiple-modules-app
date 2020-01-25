package com.chhaichivon.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by Chhai Chivon
 * Date     : 1/1/20, 1:54 PM
 * Email    : chhai.chivon@prasac.com.kh
 */
@Configuration
//@EnableSwagger
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/developer").setViewName("swagger");
        registry.addViewController("/access-denied").setViewName("access-denied");

    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                .allowedOrigins("*");
    }

    /*
    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setMaxUploadSizePerFile(104857600);
        return resolver;
    }

	 @Bean
     public MultipartFilter multipartFilter() {
	            MultipartFilter multipartFilter = new MultipartFilter();
	        multipartFilter.setMultipartResolverBeanName("multipartResolver");
	        return multipartFilter;
    }
    */

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
        registry.addResourceHandler("/files/images/**").addResourceLocations("file:/opt/images/");
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        registry.viewResolver(resolver);
    }
}
