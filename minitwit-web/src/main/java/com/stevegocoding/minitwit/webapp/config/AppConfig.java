package com.stevegocoding.minitwit.webapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by magkbdev on 7/18/16.
 */

@Configuration
@Import(value = {
    WebMvcConfig.class
})
public class AppConfig {
    
}
