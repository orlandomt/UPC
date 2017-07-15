package pe.pardoschicken.reserva.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by marcoor on 7/14/2017.
 */
@ConfigurationProperties(prefix = "spring.jpa.properties.hibernate")
public class HibernateProperties {

    private String dialect;
    private String showSql;
    private String releaseMode;
    private String useUnicode;
    private String charSet;
    private String packagesToScan;

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

    public String getReleaseMode() {
        return releaseMode;
    }

    public void setReleaseMode(String releaseMode) {
        this.releaseMode = releaseMode;
    }

    public String getUseUnicode() {
        return useUnicode;
    }

    public void setUseUnicode(String useUnicode) {
        this.useUnicode = useUnicode;
    }

    public String getCharSet() {
        return charSet;
    }

    public void setCharSet(String charSet) {
        this.charSet = charSet;
    }

    public String getPackagesToScan() {
        return packagesToScan;
    }

    public void setPackagesToScan(String packagesToScan) {
        this.packagesToScan = packagesToScan;
    }
}
