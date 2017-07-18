package pe.pardoschicken.reserva.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Orlando on 15/07/2017.
 */
@SpringBootApplication
@EnableConfigurationProperties
public class ReservaApplication {

    public static void main(String[] args){
        SpringApplication.run(ReservaApplication.class, args);
    }
}
