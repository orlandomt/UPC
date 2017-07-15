package pe.pardoschicken.reserva.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

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
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(){
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        Properties properties = new Properties();

        properties.put("hibernate.dialect", hibernateProperties.getDialect());
        properties.put("hibernate.show_sql", hibernateProperties.getShowSql());
        properties.put("hibernate.connection.release_mode", hibernateProperties.getReleaseMode());
        properties.put("hibernate.connection.useUnicode", hibernateProperties.getUseUnicode());
        properties.put("hibernate.connection.charSet", hibernateProperties.getCharSet());

        entityManagerFactory.setDataSource(dataSource());
        entityManagerFactory.setPackagesToScan(hibernateProperties.getPackagesToScan());
        entityManagerFactory.setJpaVendorAdapter(vendorAdapter);
        entityManagerFactory.setJpaProperties(properties);

        return entityManagerFactory;
    }

    @Bean
    public JpaTransactionManager transactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());

        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }
}