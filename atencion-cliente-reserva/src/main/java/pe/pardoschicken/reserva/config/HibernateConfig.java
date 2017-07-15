package pe.pardoschicken.reserva.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

/**
 * Created by marcoor on 7/14/2017.
 */
@Configuration
@EnableConfigurationProperties({DatabaseProperties.class, HibernateProperties.class})
public class HibernateConfig {

    @Autowired
    DatabaseProperties databaseProperties;

    @Autowired
    HibernateProperties hibernateProperties;

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(databaseProperties.getDriver());
        driverManagerDataSource.setUrl(databaseProperties.getUrl());
        driverManagerDataSource.setUsername(databaseProperties.getUsername());
        driverManagerDataSource.setPassword(databaseProperties.getPassword());

        return driverManagerDataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean


}
