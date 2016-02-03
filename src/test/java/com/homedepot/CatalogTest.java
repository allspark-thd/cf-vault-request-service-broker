package com.homedepot;

import com.homedepot.config.CatalogConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.cloud.servicebroker.model.Catalog;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CfVaultRequestServiceBrokerApplication.class)
public class CatalogTest {

    Catalog catalog;

//    MockMvc mockMvc;
//
//    @Before
//    public void setUp() {
//        catalog = new CatalogConfig().newCatalog();
//        mockMvc = MockMvcBuilders.standaloneSetup(new CatalogController
//                (new BeanCatalogService(catalog)))
//                .build();
//    }
//
//    @Test
//    public void itShouldRespondToTheCatalogEndpoint() throws Exception {
//        mockMvc.perform(get("/v2/catalog")
//                    .header("X-Broker-Api-Version", "2.8"))
//                .andExpect(status().isOk());
//    }

    @Test
    public void catalogContainsNeededFieldsForBaseProject() {
        catalog = new CatalogConfig().newCatalog();
        assertThat(catalog.getServiceDefinitions(),hasSize(1));
    }


}