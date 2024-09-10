package nunes03.com.github.expensemanager.database.settings;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DatabaseSettings {

    String url;

    String username;

    String password;

    String driverClassName;
}