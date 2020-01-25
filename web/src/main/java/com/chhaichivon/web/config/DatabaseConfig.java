package com.chhaichivon.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Created by Chhai Chivon
 * Date     : 1/1/20, 1:54 PM
 * Email    : chhai.chivon@prasac.com.kh
 */

@Configuration
public class DatabaseConfig {

    private final Environment environment;

    public DatabaseConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("PRASAC.WS.DB.DRIVER"));
        dataSource.setUrl( "jdbc:mysql://"+ environment.getProperty("PRASAC.WS.DB.IP") +":"+ environment.getProperty("PRASAC.WS.DB.PORT") +"/"+ environment.getProperty("PRASAC.WS.DB.DBNAME") +"?useSSL=false" );
        dataSource.setUsername(environment.getProperty("PRASAC.WS.DB.USERNAME"));
        dataSource.setPassword(environment.getProperty("PRASAC.WS.DB.PASSWORD"));
        return dataSource;
    }
}
