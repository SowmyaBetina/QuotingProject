package com.project.quote;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

//class QuoteControllerTest {
//
//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
//
//}

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.project.quote.dto.FeatureDTO;
import com.project.quote.dto.ParameterDTO;
import com.project.quote.dto.ProductDTO;
import com.project.quote.entity.Customer;
import com.project.quote.entity.Feature;
import com.project.quote.entity.Location;
import com.project.quote.entity.Parameter;
import com.project.quote.entity.Product;
import com.project.quote.entity.Quote;
import com.project.quote.entity.User;
import com.project.quote.repository.CustomerRepository;
import com.project.quote.repository.LocationRepository;
import com.project.quote.repository.QuoteRepository;
import com.project.quote.service.FeatureService;
import com.project.quote.service.ParameterService;
import com.project.quote.service.ProductService;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class QuoteControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuoteRepository quoteRepository;

    @MockBean
    private CustomerRepository customerRepository;

    @MockBean
    private LocationRepository locationRepository;

    @MockBean
    private ProductService productService;

    @MockBean
    private FeatureService featureService;

    @MockBean
    private ParameterService parameterService;

    @BeforeEach
    public void setUp() {
        // Mock data setup for QuoteRepository
        Quote quote = new Quote();
//        quote.setId(1L);
        quote.setQuoteName("Test Quote");
        quote.setQuoteOwner("Test Owner");

        // Mock data setup for CustomerRepository
        Customer customer = new Customer();
//        customer.setId(1L);
        customer.setCustomerName("Test Customer");
        customer.setAccountStatus("Active");

        // Mock data setup for LocationRepository
        Location location = new Location();
        //location.setId(1L);
        //location.setName("Test Location");

        // Mock data setup for ProductService
        ProductDTO productDTO = new ProductDTO();
        //productDTO.setId(1L);
        productDTO.setName("Test Product");

        Mockito.when(quoteRepository.findAll()).thenReturn(Arrays.asList(quote));
        Mockito.when(customerRepository.findAll()).thenReturn(Arrays.asList(customer));
        Mockito.when(locationRepository.findAll()).thenReturn(Arrays.asList(location));
        Mockito.when(productService.getAllProducts()).thenReturn(Arrays.asList(productDTO));
    }

    @Test
    public void testGetSelectedData() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/quotes/select"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].quoteName").value("Test Quote"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].quoteOwner").value("Test Owner"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].customerName").value("Test Customer"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].accountStatus").value("Active"));
    }

   

    @Test
    public void testGetAllProducts() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/quotes/productslist"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Test Product"));
    }
    
    
//    @Test
//    public void testCustomerEntity() {
//        Customer customer = new Customer();
//        customer.setCustomerId(1L);
//        customer.setCustomerName("Test Customer");
//        customer.setAccountStatus("Active");
//
//        assertEquals(1L, customer.getCustomerId());
//        assertEquals("Test Customer", customer.getCustomerName());
//        assertEquals("Active", customer.getAccountStatus());
//    }
//
//    @Test
//    public void testFeatureEntity() {
//        Feature feature = new Feature();
//        feature.setId(1);
//        feature.setName("Test Feature");
//        feature.setInternalName("Internal Feature");
//        feature.setDetails("Feature details");
//
//        assertEquals(1, feature.getId());
//        assertEquals("Test Feature", feature.getName());
//        assertEquals("Internal Feature", feature.getInternalName());
//        assertEquals("Feature details", feature.getDetails());
//    }
//
//    @Test
//    public void testLocationEntity() {
//        Location location = new Location();
//        //location.setId(1);
//        location.setLocation("Test Location");
//        location.setStreet("Test Street");
//        location.setCity("Test City");
//        location.setState("Test State");
//        location.setCountry("Test Country");
//
//        //assertEquals(1, location.getId());
//        assertEquals("Test Location", location.getLocation());
//        assertEquals("Test Street", location.getStreet());
//        assertEquals("Test City", location.getCity());
//        assertEquals("Test State", location.getState());
//        assertEquals("Test Country", location.getCountry());
//    }
//
//    @Test
//    public void testParameterEntity() {
//        Parameter parameter = new Parameter();
//        parameter.setId(1);
//        parameter.setName("Test Parameter");
//        parameter.setDetails("Parameter details");
//        parameter.setPrice("10.00");
//        parameter.setQuantity("5");
//
//        assertEquals(1, parameter.getId());
//        assertEquals("Test Parameter", parameter.getName());
//        assertEquals("Parameter details", parameter.getDetails());
//        assertEquals("10.00", parameter.getPrice());
//        assertEquals("5", parameter.getQuantity());
//    }
//
//    @Test
//    public void testUserEntity() {
//        User user = new User();
//        user.setId(1);
//        user.setName("Test User");
//        user.setPassword("password");
//        user.setRole("user");
//
//        assertEquals(1, user.getId());
//        assertEquals("Test User", user.getName());
//        assertEquals("password", user.getPassword());
//        assertEquals("user", user.getRole());
//    }
//
//
//    @Test
//    public void testProductEntity() {
//        Product product = new Product();
//        product.setId(1);
//        product.setName("Test Product");
//        product.setInternalName("Internal Product");
//        product.setDetails("Product details");
//        product.setMaxProductsPerLocation(10);
//
//        assertEquals(1, product.getId());
//        assertEquals("Test Product", product.getName());
//        assertEquals("Internal Product", product.getInternalName());
//        assertEquals("Product details", product.getDetails());
//        assertEquals(10, product.getMaxProductsPerLocation());
//    }


   

   
 
}

