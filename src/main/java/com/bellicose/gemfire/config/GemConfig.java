package com.bellicose.gemfire.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.gemfire.CacheFactoryBean;
import org.springframework.data.gemfire.LocalRegionFactoryBean;

import com.gemstone.gemfire.cache.GemFireCache;
import com.bellicose.gemfire.model.Automovil;

@Configuration
public class GemConfig {
	@Bean
	LocalRegionFactoryBean<String, Automovil> customerRegion(final GemFireCache cache) {
		LocalRegionFactoryBean<String, Automovil> customerRegion = new LocalRegionFactoryBean<>();
		customerRegion.setCache(cache);
		customerRegion.setName("automovil");
		customerRegion.setPersistent(false);
		return customerRegion;
	}
    @Bean
    Properties gemfireProperties() {
        Properties gemfireProperties = new Properties();
        gemfireProperties.setProperty("name", "EmbeddedGemfireApplication");
        gemfireProperties.setProperty("mcast-port", "0");
        return gemfireProperties;
    }
    
    @Bean
    CacheFactoryBean gemfireCache() {
        CacheFactoryBean gemfireCache = new CacheFactoryBean();
        gemfireCache.setProperties(gemfireProperties());
        return gemfireCache;
    }
    
}