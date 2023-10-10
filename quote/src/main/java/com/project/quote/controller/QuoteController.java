package com.project.quote.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.quote.dto.QuoteCustomerDTO;
import com.project.quote.entity.Customer;
import com.project.quote.entity.Quote;
import com.project.quote.repository.CustomerRepository;
import com.project.quote.repository.QuoteRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/quotes")
public class QuoteController {
	
	@Autowired
	private QuoteRepository quoteRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping("/select")
    public List<QuoteCustomerDTO> getSelectedData() {
        List<QuoteCustomerDTO> result = new ArrayList<>();

        Customer customer = customerRepository.findAll().get(0); // Assuming there is only one customer

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
}
	
