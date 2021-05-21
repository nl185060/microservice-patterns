package com.ncr.sridhar.Hystrix.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ncr.sridhar.Hystrix.Delegate.TaxServiceDelegate;

@RestController
public class SellController {

	@Autowired
    TaxServiceDelegate taxServiceDelegate;

    @RequestMapping(value = "/getTaxDetails/{retailername}", method = RequestMethod.GET)
    public String getStudents(@PathVariable String retailername) {
       System.out.println("Going to call tax service to get data!");
       return taxServiceDelegate.callTaxServiceAndGetData(retailername);
   }
}
