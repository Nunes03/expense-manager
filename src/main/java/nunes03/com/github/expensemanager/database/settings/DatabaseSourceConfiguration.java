package nunes03.com.github.expensemanager.database.settings;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@ComponentScan(
    basePackages = "nunes03.com.github"
)
public class DatabaseSourceConfiguration {

    private final DatabaseSettings databaseSettings;

    public DatabaseSourceConfiguration(DatabaseSettings databaseSettings) {
        this.databaseSettings = databaseSettings;
    }

    @Bean
    public DataSource dataSource() {
        final var dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(databaseSettings.getDriverClassName());
        dataSource.setUrl(databaseSettings.getUrl());
        dataSource.setUsername(databaseSettings.getUsername());
        dataSource.setPassword(databaseSettings.getPassword());

        return dataSource;
    }
}

