package com.acn.springbootjpa.model;


import javax.persistence.Column;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity @Table(name = "customer")
public class Customer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="fname", nullable = false, length = 40) //prevent snake case first_name
    private String firstName;
    @Column(name = "lname")
    private String lastName;
    private LocalDate birthday;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) // Wenn customer gelöscht wird, werden auch alle seine adressen gelöscht
    @JoinColumn(name = "customerid") // referenziert den foreign key
    private List<Address> addressList;


    public Customer() {
    }

    public Customer(String firstName, String lastName, LocalDate birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    public Customer(Long id, String firstName, String lastName, LocalDate birthday) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
//    public Customer(Long id, String firstName, String lastName, LocalDate birthday, List<Address> addressList) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.birthday = birthday;
//        this.addressList = addressList;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }
   public void addAddress(Address address){
        if (address == null) throw new IllegalArgumentException("address should not be null");
        if (addressList == null){
            addressList = new ArrayList<>();
        }
        addressList.add(address);
   }
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", addressList=" + addressList +
                '}';
    }
}
