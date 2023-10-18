package com.project.quote.controller;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.project.quote.business.LoginBody;
import com.project.quote.dto.FeatureDTO;
import com.project.quote.dto.ParameterDTO;
import com.project.quote.dto.ProductDTO;
import com.project.quote.dto.QuoteCustomerDTO;
import com.project.quote.entity.Customer;
import com.project.quote.entity.Feature;
import com.project.quote.entity.Location;
import com.project.quote.entity.Product;
import com.project.quote.entity.Quote;
import com.project.quote.entity.User;
import com.project.quote.repository.CustomerRepository;
import com.project.quote.repository.FeatureRepository;
import com.project.quote.repository.LocationRepository;
import com.project.quote.repository.ParameterRepository;
import com.project.quote.repository.ProductRepository;
import com.project.quote.repository.QuoteRepository;
import com.project.quote.repository.UserRepository;
import com.project.quote.service.FeatureService;
import com.project.quote.service.ParameterService;
import com.project.quote.service.ProductService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/quotes")
public class QuoteController {
	
	@Autowired
	private QuoteRepository quoteRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private LocationRepository locationRepository;	
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private FeatureRepository featureRepository;
	@Autowired
	private ParameterRepository parameterRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProductService productService;
	@Autowired
	private FeatureService featureService;
	@Autowired
	private ParameterService parameterService;
	@Autowired 
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        try {
            if (userRepository.existsByName(user.getName())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username already exists");
            }
       user.setName(user.getName());
       user.setPassword(passwordEncoder.encode(user.getPassword()));
       userRepository.save(user);
       return ResponseEntity.ok("User registered successfully");
        } 
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Registration failed: " + e.getMessage());
        }
    }
	
	@GetMapping("/productnames")
	public List<String> getProductNames() {
        return productService.getAllProductNames();
    }
	
	@GetMapping("/select")
    public List<QuoteCustomerDTO> getSelectedData() {
        List<QuoteCustomerDTO> result = new ArrayList<>();
        Customer customer = customerRepository.findAll().get(0); 
        List<Quote> quotes = quoteRepository.findAll();        
        for (Quote quote : quotes) {
            QuoteCustomerDTO dto = new QuoteCustomerDTO();
            dto.setQuoteName(quote.getQuoteName());
            dto.setQuoteOwner(quote.getQuoteOwner());
            dto.setCustomerName(customer.getCustomerName());
            dto.setAccountStatus(customer.getAccountStatus());
            result.add(dto);
        }
        return result;
    }
	
	 @GetMapping("/location")
	    public List<Location> getAllLocations() {
	        return locationRepository.findAll();
	}
	 
	 @PostMapping("/addlocation")
	    public Location createLocation(@RequestBody Location location) {
	        return locationRepository.save(location);
	 }
	 
	 @GetMapping("/productslist")
	 public List<ProductDTO> getAllProducts() {
	        return productService.getAllProducts();
	    }
	 
	 

	 @GetMapping("/features/{name}")
	    public List<FeatureDTO> getFeaturesForProduct(@PathVariable String name) {
	        return featureService.getFeaturesForProduct(name);
	    }
	 

	 @GetMapping("/parameters/{name}")
	    public List<ParameterDTO> getParametersForFeature(@PathVariable String name) {
	        return parameterService.getParametersForFeature(name);
	    }

	 
}


