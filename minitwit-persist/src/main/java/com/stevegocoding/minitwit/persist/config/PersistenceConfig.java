package com.stevegocoding.minitwit.persist.config;

import com.stevegocoding.minitwit.persist.repository.UserRepository;
import com.stevegocoding.minitwit.persist.repository.impl.JdbcUserRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * Created by magkbdev on 7/21/16.
 */

@Configuration
public class PersistenceConfig {

    @Bean
    public DataSource devDataSource() {
        DataSource ds = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:db/sql/schema.sql")
                .addScript("classpath:db/sql/data.sql")
                .build();
        return ds;
    }

    /*
    @Profile("test")
    @Bean(name = "dataSource")
    public DataSource tesDataSource() {
        return null;
    }
    */


    @Bean
    public NamedParameterJdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    public UserRepository userRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        return new JdbcUserRepositoryImpl(namedParameterJdbcTemplate);
    }

}

