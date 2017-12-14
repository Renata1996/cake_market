package busket;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class BusketApplication {

    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER_NAME = "Renata";
    private static final String PASSWORD = "0000";
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";


    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create().url(URL)
                .username(USER_NAME).password(PASSWORD).driverClassName(DRIVER).build();
    }

    public static void main(String[] args) {
        SpringApplication.run(BusketApplication.class, args);

    }
}

