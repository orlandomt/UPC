package pe.pardoschicken.reserva.config;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;

/**
 * Created by Orlando on 16/07/2017.
 */
@Configuration
@MapperScan("pe.pardoschicken.reserva.dao")
@EnableConfigurationProperties(MybatisProperties.class)
public class MybatisConfig {

    @Autowired
    private MybatisProperties mybatisProperties;

    @Bean
    public DataSource dataSource(){
        PooledDataSource pooledDataSource = new PooledDataSource();
        pooledDataSource.setDriver(mybatisProperties.getDriver());
        pooledDataSource.setUrl(mybatisProperties.getUrl());
        pooledDataSource.setUsername(mybatisProperties.getUsername());
        pooledDataSource.setPassword(mybatisProperties.getPassword());

        return pooledDataSource;
    }

    @Bean
    public DataSourceTransactionManager transactionManager(){
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean() throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        sqlSessionFactoryBean.setTypeAliasesPackage("pe.pardoschicken.reserva.model");

        return sqlSessionFactoryBean;
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/pardoschicken").allowedOrigins("*");
            }
        };
    }
}
