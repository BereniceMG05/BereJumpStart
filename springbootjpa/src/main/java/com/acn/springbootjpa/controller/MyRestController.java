package com.acn.springbootjpa.controller;

import com.acn.springbootjpa.model.Address;
import com.acn.springbootjpa.model.Customer;
import com.acn.springbootjpa.repository.CustomerRepository;
import com.acn.springbootjpa.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class MyRestController {
    @Autowired
    CustomerService customerService;

    CustomerRepository customerRepository;

   // url: localhost:8080/customers
    @GetMapping("/customers")
    public List<Customer> getCustomers(){
        return customerService.getAllCustomer();
    }
    @GetMapping("/customers/birthday/{birthday}")
    public List<Customer> getCustomersByBirthday(
            @PathVariable(  "birthday") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate birthday){
        return customerService.getCustomerByBirthday(birthday);
    }
    // url: localhost:8080/customers/1001
    @GetMapping("/customers/{myid}")
    public Customer getCustomerById(@PathVariable(value = "myid") Long id){
        return customerService.getCustomerById(id);
    }
    //http://localhost:8080/customers/name?fname=peter&lname=pan
    @GetMapping("/customers/name")
    public List<Customer> getCustomerByName(@RequestParam("fname") String fname, @RequestParam("lname") String lname){
        return customerService.getCustomerByName(fname,lname);
    }
    //http://localhost:8080/customers/{myid}/addresses
    @GetMapping("/customers/{myid}/addresses")
    public List<Address> getAddressesFromCustomer(@PathVariable("myid") Long id){
        return customerService.getAddressesFromCustomer(id);
    }

    @PostMapping("/customers/new")
    public Customer newCustomer(@RequestBody Customer cust){
        customerService.saveCustomer(cust);
        return cust;
    }
    @PutMapping("/customers/update")
    public Customer changeCustomer(@RequestBody Customer cust){
        customerService.updateCustomer(cust);
        return cust;
    }
    //http://localhost:8080/customers/remove/1012
     @DeleteMapping("/customers/remove/{myid}")
            public void changeCustomer(@PathVariable("myid") Long id){
            customerService.deleteCustomerById(id);
    }
}
