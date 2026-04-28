package com.AutoServix.AutoServix.Models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Customer")
public class CustomerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Customer_id;

    private String Name;

    @Column(unique = true)
    private String Email;

    public CustomerModel(Object customerId, String name, String email, String password) {
    }

    public String getModelNo() {
        return ModelNo;
    }

    public CustomerModel(Integer customer_id, String name, String email, String modelNo, String brand, LocalDateTime slot, Integer chassisNo, Integer serviceCount) {
        Customer_id = customer_id;
        Name = name;
        Email = email;
        ModelNo = modelNo;
        Brand = brand;
        this.slot = slot;
        ChassisNo = chassisNo;
        ServiceCount = serviceCount;
    }

    public void setModelNo(String modelNo) {
        ModelNo = modelNo;
    }

    public Integer getCustomer_id() {
        return Customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        Customer_id = customer_id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public LocalDateTime getSlot() {
        return slot;
    }

    public void setSlot(LocalDateTime slot) {
        this.slot = slot;
    }

    public Integer getChassisNo() {
        return ChassisNo;
    }

    public void setChassisNo(Integer chassisNo) {
        ChassisNo = chassisNo;
    }

    public Integer getServiceCount() {
        return ServiceCount;
    }

    public void setServiceCount(Integer serviceCount) {
        ServiceCount = serviceCount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Column(nullable = false)
    private String password;

    private String role;

    @Column(nullable = false)
    private String ModelNo;

    @Column(nullable = false)
    private String Brand;

    private LocalDateTime slot;

    @Column(nullable = false)
    private Integer ChassisNo;

    private Integer ServiceCount;

}
