package edu.uniandes.arquitectura.servicios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * Clase principal de ejecucion de aplicacion con spring boot.
 */
@SpringBootApplication
@EnableScheduling
@EnableCaching
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class MainApp extends SpringBootServletInitializer{	
	
    /**
	 * Main.
	 * 
	 * @param args
	 *            Argumentos.
	 * @throws Exception
	 */
	public static final void main(final String[] args) throws Exception {
		SpringApplication.run(MainApp.class, args);
	}
	
    /**
	 * Obtiene la configuración de los caches creados en el sistema
	 * @return Objecto EhCacheManagerFactoryBean
	 */
    @Bean
    public EhCacheManagerFactoryBean ehCacheCacheManager() {
        EhCacheManagerFactoryBean managerFactoryBean = new EhCacheManagerFactoryBean();
        managerFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
        managerFactoryBean.setShared(true);
        return managerFactoryBean;
    }
    
    @Bean
    public CacheManager cacheManager() {
		return new EhCacheCacheManager(ehCacheCacheManager().getObject());
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
    	return application.sources(MainApp.class);
    }
}
