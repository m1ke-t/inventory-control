package com.mititch.inventoryctrl.configuration;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mititch.inventoryctrl.dto.UserDetailsView;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.userdetails.UserDetails;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.mititch.inventoryctrl.model"})
@EnableJpaRepositories(basePackages = {"com.mititch.inventoryctrl.dao"})
@ComponentScan(basePackages = "com.mititch.inventoryctrl.dao")
public class AppConfig {
//    @Bean("transactionMapperFacade")
//    public MapperFacade getTransactionMapperFacade() {
//        MapperFactory factory = new DefaultMapperFactory
//                .Builder()
//                .build();
//        factory.registerClassMap(factory.classMap(TransactionView.class,MT940Transaction.class).mapNulls(false).byDefault().toClassMap());
//        return factory.getMapperFacade();
//    }

    @Bean("userDetailsMapperFacade")
    public MapperFacade getUserDetailsMapperFacade() {
        MapperFactory factory = new DefaultMapperFactory
                .Builder()
                .build();
        factory.registerClassMap(factory.classMap(UserDetailsView.class, UserDetails.class).mapNulls(false).exclude("authorities").byDefault().toClassMap());
        return factory.getMapperFacade();
    }

    @Bean
    ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false );
        return objectMapper;
    }


//    @Bean
//    MT940TransactionSearchRequest getSearchRequest() {
//        return new MT940TransactionSearchRequest();
//    }

}
