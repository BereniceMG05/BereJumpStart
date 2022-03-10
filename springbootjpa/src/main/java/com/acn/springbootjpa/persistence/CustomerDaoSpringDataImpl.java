package com.acn.springbootjpa.persistence;

import com.acn.springbootjpa.model.Customer;
import com.acn.springbootjpa.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
@Primary
public class CustomerDaoSpringDataImpl implements CustomerDao {


    private CustomerRepository customerRepository;

    public CustomerDaoSpringDataImpl() {
    }

    @Autowired
    public CustomerDaoSpringDataImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomer() {
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public List<Customer> getAllCustomerByCity(String city) {
        return customerRepository.getCustomerByCity(city);
    }

    @Override
    public List<Customer> getCustomerByName(String fname, String lname) {
        return customerRepository.findCustomerByFirstNameAndLastName(fname, lname);
    }

    @Override
    public Customer getCustomerById(Long id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            return optionalCustomer.get();
        }
        return null;
    }

    @Override
    public Optional<Customer> getOptionalCustomerById(Long id) {

        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> getCustomerByBirthday(LocalDate birthday) {

        return customerRepository.findCustomerByBirthday(birthday);
    }

    @Override
    public List<Customer> getCustomerOlderThanDate(LocalDate date) {
        return customerRepository.findCustomerByBirthdayLessThan(date);

    }

    @Override
    public void saveCustomer(Customer cust) {
        customerRepository.save(cust);
    }

    @Override
    public void updateCustomer(Customer cust) {
        customerRepository.save(cust);

    }

    @Override
    public void updateCustomerName(Long id, String fname, String lname) {
        customerRepository.updateCustomerName(id, fname, lname);
    }

    @Override
    public void deleteCustomer(Customer cust) {
        if(customerRepository.existsById(cust.getId()))
            customerRepository.deleteById(cust.getId());

    }

    @Override
    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);

    }




}
