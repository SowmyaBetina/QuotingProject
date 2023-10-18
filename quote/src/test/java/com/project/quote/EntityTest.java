package com.project.quote;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import org.springframework.boot.test.context.SpringBootTest;

import com.project.quote.entity.Customer;
import com.project.quote.entity.Feature;
import com.project.quote.entity.Location;


@SpringBootTest

public class EntityTest {

    @Test
    public void testCustomerEntity() {
        Customer customer = new Customer();
        customer.setCustomerId(1L);
        customer.setCustomerName("Test Customer");
        customer.setAccountStatus("Active");

        //assertEquals(1L, customer.getCustomerId());
        assertEquals("Test Customer", customer.getCustomerName());
        assertEquals("Active", customer.getAccountStatus());
    }

    @Test
    public void testFeatureEntity() {
        Feature feature = new Feature();
        feature.setId(1);
        feature.setName("Test Feature");
        feature.setInternalName("Internal Feature");
        feature.setDetails("Feature details");

        assertEquals(1, feature.getId());
        assertEquals("Test Feature", feature.getName());
        assertEquals("Internal Feature", feature.getInternalName());
        assertEquals("Feature details", feature.getDetails());
    }

    @Test
    public void testLocationEntity() {
        Location location = new Location();
        //location.setId(1);
        location.setLocation("Test Location");
        location.setStreet("Test Street");
        location.setCity("Test City");
        location.setState("Test State");
        location.setCountry("Test Country");

        //assertEquals(1, location.getId());
        assertEquals("Test Location", location.getLocation());
        assertEquals("Test Street", location.getStreet());
        assertEquals("Test City", location.getCity());
        assertEquals("Test State", location.getState());
        assertEquals("Test Country", location.getCountry());
    }

    
}

