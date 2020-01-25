package com.chhaichivon.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by Chhai Chivon
 * Date     : 1/1/20, 1:54 PM
 * Email    : chhai.chivon@prasac.com.kh
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = { "com.chhaichivon" })
@EntityScan(basePackages = {"com.chhaichivon"})
@ComponentScan(basePackages = {"com.chhaichivon"})
public class WebApplication  {

    public static void main(String[] args){
        SpringApplication.run(WebApplication.class);
    }
}
