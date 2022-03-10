package com.acn.springbootjpa.persistence;

import com.acn.springbootjpa.model.Address;
import com.acn.springbootjpa.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CustomerDaoSpringJdbcImplTest {
    @Autowired
    CustomerDao customerDao;  //Dependency Injection
//    @BeforeEach
//    void setUp() {
//    }
//
//    @AfterEach
//    void tearDown() {
//    }

    @Test
    void getAllCustomer() {
        assertNotNull(customerDao);
        List<Customer> customerList = customerDao.getAllCustomer();
        assertNotNull(customerList);
        assertTrue(customerList.size() > 0);
        customerList.forEach(System.out::println);
    }

    @Test
    void getCustomerByName() {
        String usedFirstName = "Johnny";
        String usedLastName = "Depp";
        assertNotNull(customerDao);
        List<Customer> customerList = customerDao.getCustomerByName(usedFirstName,usedLastName);
        assertNotNull(customerList);
        assertTrue(customerList.size() > 0);
        for (Customer cust: customerList  ) {
            assertEquals(usedFirstName, cust.getFirstName());
            assertEquals(usedLastName, cust.getLastName() );

        }
        customerList.forEach(System.out::println);
    }

    @Test
    void getCustomerById() {
        Long usedID = 1003L;
        assertNotNull(customerDao);
        Customer customer = customerDao.getCustomerById(usedID);
        assertNotNull(customer);
        assertEquals(usedID, customer.getId());
        System.out.println(customer);
    }
    @Test
    void getCustomerByBadId() {
        Long usedID = 10033L;
        assertNotNull(customerDao);
        Customer customer = customerDao.getCustomerById(usedID);
        assertNull(customer);

    }

    @Test
    void getOptionalCustomerById() {
        Long usedID = 1003L;
        assertNotNull(customerDao);
        Optional<Customer> optionalCustomer = customerDao.getOptionalCustomerById(usedID);
        assertTrue(optionalCustomer.isPresent());
        Customer customer = optionalCustomer.get();
        assertEquals(usedID, customer.getId());
        System.out.println(customer);
    }

    @Test
    void getCustomerByBirthday() {
        LocalDate usedBirthday = LocalDate.of(1963, 6, 6);

        assertNotNull(customerDao);
        List<Customer> customerList = customerDao.getCustomerByBirthday(usedBirthday);
        assertNotNull(customerList);
        assertTrue(customerList.size() > 0);
        for (Customer cust: customerList  ) {
            assertEquals(usedBirthday, cust.getBirthday());
        }
        customerList.forEach(System.out::println);
    }

    @Test
    void getCustomerOlderThanDate() {
        LocalDate usedDate = LocalDate.of(1950, 9, 8);
//        LocalDate usedDate = LocalDate.now();

        assertNotNull(customerDao);
        List<Customer> customerList = customerDao.getCustomerOlderThanDate(usedDate);
        assertNotNull(customerList);
        assertTrue(customerList.size() > 0);
        for (Customer cust: customerList  ) {
            assertTrue(usedDate.isAfter( cust.getBirthday() ));
        }
        customerList.forEach(System.out::println);
    }

    @Test
    void saveCustomer() {
        String fname = "Captain";
        String lname = "Sparrow2";
        LocalDate birthday = LocalDate.of(1974, 4, 11);
        Customer cust = new Customer(fname,lname , birthday);
        cust.addAddress(new Address("20076","Barenberge","Waldstr. 188"));
        System.out.println(cust);
        assertNotNull(customerDao);
        customerDao.saveCustomer(cust);
        assertNotNull(cust.getId());
        System.out.println(cust);

    }

    @Test
    void updateCustomer() {
        String newFirstname = "Pancho";
        String newLastname = "Villa";
        Long usedID = 1013L;
        assertNotNull(customerDao);
        Customer customer = customerDao.getCustomerById(usedID);
        assertNotNull(customer);
        assertEquals(usedID, customer.getId());
        System.out.println(customer);
        customer.setFirstName(newFirstname);
        customer.setLastName(newLastname);
        Address address = customer.getAddressList().get(0);
        address.setZipcode("31065");
        address.setCity("Chihuahua");
        address.setStreet("Avenida Juarez  25");
        customerDao.updateCustomer(customer);
        customer = customerDao.getCustomerById(usedID);
        assertEquals(newFirstname,customer.getFirstName());
        assertEquals(newLastname,customer.getLastName());
        System.out.println(customer);
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