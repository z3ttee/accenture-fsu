package me.zitzmanncedric.conferencedemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class PersistenceConfiguration {

    /*
     * Non-named beans will be created byType -> Only one instance
     * in the spring context will be created.
     *
     * In this case: A "app-wide" dataSource is configured.
     */
    @Bean
    public DataSource dataSource() {
        DataSourceBuilder builder = DataSourceBuilder.create();
        builder.url("${DB_URL}");
        builder.username("dataSourceUser").password("dataSourcePass");

        System.out.println("Custom datasource bean has been initialized and set");
        return builder.build();
    }

}
