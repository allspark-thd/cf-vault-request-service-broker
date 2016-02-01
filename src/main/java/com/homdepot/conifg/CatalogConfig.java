package com.homdepot.conifg;

import org.apache.log4j.Logger;
import org.springframework.cloud.servicebroker.model.Catalog;
import org.springframework.cloud.servicebroker.model.Plan;
import org.springframework.cloud.servicebroker.model.ServiceDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class CatalogConfig {

    private Logger log = Logger.getLogger(CatalogConfig.class);

    @Bean
    public Catalog newCatalog() {
        log.info("New catalog requested");
        Catalog catalog = new Catalog(Collections.singletonList(
                new ServiceDefinition("vault-request-broker",
                        "Vault Request Broker",
                        "A vault credentials provisioner",
                        true,
                        false,
                        Collections.singletonList(
                                new Plan("default-platn",
                                        "The Default Plan",
                                        "This is the long form description",
                                        getPlanMetadata())),
                        Arrays.asList("credentials", "secure"),
                        getServiceDefinitionMetadata(),
                        null,
                        null)));
        return catalog;
    }

    private Map<String, Object> getPlanMetadata() {
        return new HashMap<String, Object>();
    }

    private Map<String, Object> getServiceDefinitionMetadata() {
        return  new HashMap<String, Object>();
    }
}
