package com.ncr.sridhar.Hystrix.Delegate;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class TaxServiceDelegate {
	
	@Autowired
    RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "callTaxServiceAndGetData_Fallback")
    public String callTaxServiceAndGetData(String retailername) {
 
        System.out.println("Getting tax details for " + retailername);
 
        String response = restTemplate
                .exchange("http://localhost:9095/getTaxDetailsForRetailer/{retailername}"
                , HttpMethod.GET
                , null
                , new ParameterizedTypeReference<String>() {
            }, retailername).getBody();
 
        System.out.println("Response Received as " + response + " -  " + new Date());
 
        return "NORMAL FLOW !!! - Retailer Name -  " + retailername + " :::  " +
                    " Store Details " + response + " -  " + new Date();
    }
     
    @SuppressWarnings("unused")
    private String callTaxServiceAndGetData_Fallback(String retailername) {
 
        System.out.println("Tax Service is down!!! fallback route enabled...");
 
        return "CIRCUIT BREAKER ENABLED!!! No Response From Tax Service at this moment. " +
                    " Service will be back shortly - " + new Date();
    }
 
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
