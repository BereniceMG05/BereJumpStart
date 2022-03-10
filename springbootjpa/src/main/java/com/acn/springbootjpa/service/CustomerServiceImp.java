package com.acn.springbootjpa.service;

import com.acn.springbootjpa.model.Address;
import com.acn.springbootjpa.model.Customer;
import com.acn.springbootjpa.persistence.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImp implements CustomerService{
    @Autowired
    CustomerDao customerDao;
    @Override
    public List<Customer> getAllCustomer() {
        return customerDao.getAllCustomer();
    }

    @Override
    public List<Customer> getCustomerByName(String fname, String lname) {
        return customerDao.getCustomerByName(fname,lname);
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerDao.getCustomerById(id);
    }

    @Override
    public Optional<Customer> getOptionalCustomerById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Customer> getCustomerByBirthday(LocalDate birthday) {
        return customerDao.getCustomerByBirthday(birthday);
    }

    @Override
    public List<Customer> getCustomerOlderThanDate(LocalDate date) {
        return customerDao.getCustomerOlderThanDate(date);
    }

    @Override
    public List<Address> getAddressesFromCustomer(Long id) {
        Customer cust = customerDao.getCustomerById(id);
        return cust.getAddressList();
    }

    @Override
    public void saveCustomer(Customer cust) {
        customerDao.saveCustomer(cust);

    }

    @Override
    public void updateCustomer(Customer cust) {
        customerDao.updateCustomer(cust);
    }

    @Override
    public void updateCustomerName(Long id, String fname, String lname) {
      customerDao.updateCustomerName(id,fname,lname);
    }

    @Override
    public void deleteCustomer(Customer cust) {

    }

    // @Override
    //public void deleteCustomer(Customer cust) {
      //  customerDao.deleteCustomer(cust);

    //}

    @Override
    public void deleteCustomerById(Long id) {
        customerDao.deleteCustomerById(id);
    }
}
