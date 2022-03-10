package com.acn.springbootjpa.repository;

import com.acn.springbootjpa.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findCustomerByBirthday(LocalDate birthday);

    List<Customer> findCustomerByBirthdayLessThan(LocalDate birthday);

    List<Customer> findCustomerByFirstNameAndLastName(String firstname, String lastname);

    @Query(value = "SELECT * FROM customer c inner join address a on c.id = a.customerid where city = :city", nativeQuery = true)
    List<Customer> getCustomerByCity(String city);

    @Modifying
    @Query(value = "update customer set fname = :fname, lname = :lname where id = :id", nativeQuery = true)
    void updateCustomerName(Long id, String fname, String lname);



}
