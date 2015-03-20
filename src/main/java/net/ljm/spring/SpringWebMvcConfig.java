package net.ljm.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/* 
 * This class further configures Spring MVC. The annotations below direct Spring where to scan for annotated classes and methods
 * and provides utility configuration not handled elsewhere.
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="net.ljm")
public class SpringWebMvcConfig extends WebMvcConfigurerAdapter {

	//Tell Spring that we want to serve static content and it should look for
	//these resources in the root of the jar in the various directories listed
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/js/");
    }

}
