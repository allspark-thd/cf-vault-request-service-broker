package com.homdepot;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.cloud.servicebroker.controller.CatalogController;
import org.springframework.cloud.servicebroker.model.Catalog;
import org.springframework.cloud.servicebroker.service.BeanCatalogService;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CfVaultRequestServiceBrokerApplication.class)
public class CatalogTest {

    @Autowired
    Catalog catalog;

    MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new CatalogController
                (new BeanCatalogService(catalog)))
                .build();
    }

    @Test
    public void itShouldRespondToTheCatalogEndpoint() throws Exception {
        mockMvc.perform(get("/v2/catalog")
                    .header("X-Broker-Api-Version", "2.8"))
                .andExpect(status().isOk());
    }
}