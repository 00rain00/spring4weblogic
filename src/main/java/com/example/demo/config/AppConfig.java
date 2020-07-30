package com.example.demo.config;

import javax.naming.NamingException;
// import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
// import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainer;
// import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.jndi.JndiTemplate;
 @Configuration
// @EnableTransactionManagement
// //@EnableJpaRepositories(basePackages = "com.roytuts.spring.boot.jndi.datasource.repository")
public class AppConfig {
   
	

// @Bean(name = "dataSource", destroyMethod = "")
// public DataSource dataSource() throws IllegalArgumentException, NamingException 
// {
//     JndiTemplate jndiTemplate = new JndiTemplate();
//     DataSource dataSource = (DataSource) jndiTemplate.lookup("java:comp/env/JDBC/Data_Source-0");
            
//     return dataSource;
// }
	

}