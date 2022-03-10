package com.acn.springbootjpa.service;

import com.acn.springbootjpa.model.Customer;
import com.acn.springbootjpa.persistence.CustomerDao;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerServiceImpTest {

    @MockBean
    CustomerDao customerDao;

    @Autowired
    private CustomerService = new CustomerServiceImp();

    @Test
    void getAllCustomer() {
    }

    @Test
    void getCustomerByName() {
    }

    @Test
    void getCustomerById() {
    }

    @Test
    void getOptionalCustomerById() {
    }

    @Test
    void getCustomerByBirthday() {
    }

    @Test
    void getCustomerOlderThanDate() {
    }

    @Test
    void getAddressesFromCustomer() {
    }

    @Test
    void saveCustomer() {
    }

    @Test
    void updateCustomer() {
    }

    @Test
    void updateCustomerName() {
    }

    @Test
    void deleteCustomer() {
    }

    @Test
    void deleteCustomerById() {
    }
}