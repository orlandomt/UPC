package pe.pardoschicken.reserva.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by marcoor on 7/14/2017.
 */
@ConfigurationProperties(prefix = "spring.jpa.properties.hibernate")
public class HibernateProperties {

    private String dialect;
    private String showSql;

    public String getDialect() {
        return dialect;
    }

    public void setDialect(String dialect) {
        this.dialect = dialect;
    }

    public String getShowSql() {
        return showSql;
    }

    public void setShowSql(String showSql) {
        this.showSql = showSql;
    }
}
