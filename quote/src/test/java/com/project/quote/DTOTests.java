package com.project.quote;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.project.quote.dto.FeatureDTO;
import com.project.quote.dto.ParameterDTO;
import com.project.quote.dto.ProductDTO;

//class DTOTests {
//
//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
//
//}


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DTOTests {

    @Test
    public void testProductDTO() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Test Product");
        productDTO.setInternalName("Internal Product");
        productDTO.setDetails("Product details");
        productDTO.setMaxProductsPerLocation(10);

        assertEquals("Test Product", productDTO.getName());
        assertEquals("Internal Product", productDTO.getInternalName());
        assertEquals("Product details", productDTO.getDetails());
        assertEquals(10, productDTO.getMaxProductsPerLocation());
    }

    @Test
    public void testParameterDTO() {
        ParameterDTO parameterDTO = new ParameterDTO();
        parameterDTO.setName("Test Parameter");
        parameterDTO.setDetails("Parameter details");
        parameterDTO.setPrice("10.00");
        parameterDTO.setQuantity("5");

        assertEquals("Test Parameter", parameterDTO.getName());
        assertEquals("Parameter details", parameterDTO.getDetails());
        assertEquals("10.00", parameterDTO.getPrice());
        assertEquals("5", parameterDTO.getQuantity());
    }

    @Test
    public void testFeatureDTO() {
        FeatureDTO featureDTO = new FeatureDTO();
        featureDTO.setName("Test Feature");
        featureDTO.setInternalName("Internal Feature");
        featureDTO.setDetails("Feature details");

        assertEquals("Test Feature", featureDTO.getName());
        assertEquals("Internal Feature", featureDTO.getInternalName());
        assertEquals("Feature details", featureDTO.getDetails());
    }
}

