package com.ncr.sridhar.taxservice.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ncr.sridhar.taxservice.model.Tax;

@RestController
public class TaxController {
	
	private static Map<String, List<Tax>> taxDB = new HashMap<String, List<Tax>>();
	 
    static {
        taxDB = new HashMap<String, List<Tax>>();
 
        List<Tax> lst = new ArrayList<Tax>();
        Tax tax = new Tax("GST", "2");
        lst.add(tax);
        tax = new Tax("HST", "3");
        lst.add(tax);
 
        taxDB.put("Coles", lst);
 
        lst = new ArrayList<Tax>();
        tax = new Tax("GST", "4");
        lst.add(tax);
        tax = new Tax("HST", "5");
        lst.add(tax);
 
        taxDB.put("STLUS", lst);
 
    }
    
    @RequestMapping(value = "/getTaxDetailsForRetailer/{retailername}", method = RequestMethod.GET)
    public List<Tax> getStudents(@PathVariable String retailername) throws Exception {
        System.out.println("Getting Student details for " + retailername);
 
        List<Tax> taxList = taxDB.get(retailername);
        if (taxList == null) {
        	taxList = new ArrayList<Tax>();
            Tax std = new Tax("Not Found", "N/A");
            taxList.add(std);
        }
        
        //Thread.sleep(10000);
        
        return taxList;
    }

}
