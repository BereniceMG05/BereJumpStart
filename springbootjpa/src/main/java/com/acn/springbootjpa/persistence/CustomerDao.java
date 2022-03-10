package com.acn.springbootjpa.persistence;

import com.acn.springbootjpa.model.Customer;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CustomerDao {
    List<Customer> getAllCustomer();
    List<Customer> getAllCustomerByCity(String city);
    List<Customer> getCustomerByName(String fname, String lname);
    Customer getCustomerById(Long id);
    Optional<Customer> getOptionalCustomerById(Long id);
    List<Customer> getCustomerByBirthday(LocalDate birthday);
    List<Customer> getCustomerOlderThanDate(LocalDate date);
    void saveCustomer(Customer cust);
    void updateCustomer(Customer cust);
    void updateCustomerName(Long id, String fname, String lname);
    void deleteCustomer(Customer cust);
    void deleteCustomerById(Long id);
}
