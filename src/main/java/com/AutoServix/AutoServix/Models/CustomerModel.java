package com.AutoServix.AutoServix.Models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "customer")
public class CustomerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    private String role;

    @Column(nullable = false)
    private String modelNo;

    @Column(nullable = false)
    private String brand;

    private LocalDateTime slot;

    @Column(nullable = false)
    private Integer chassisNo;

    private Integer serviceCount;

    public CustomerModel() {}

    public CustomerModel(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = "USER";
        this.modelNo = "UNKNOWN";
        this.brand = "UNKNOWN";
        this.chassisNo = 0;
        this.serviceCount = 0;
    }

    public CustomerModel(String name, String email, String password, String modelNo, String brand, Integer chassisNo) {
        this(name, email, password);
        this.modelNo = hasText(modelNo) ? modelNo : "UNKNOWN";
        this.brand = hasText(brand) ? brand : "UNKNOWN";
        this.chassisNo = chassisNo != null ? chassisNo : 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getModelNo() {
        return modelNo;
    }

    public void setModelNo(String modelNo) {
        this.modelNo = modelNo;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public LocalDateTime getSlot() {
        return slot;
    }

    public void setSlot(LocalDateTime slot) {
        this.slot = slot;
    }

    public Integer getChassisNo() {
        return chassisNo;
    }

    public void setChassisNo(Integer chassisNo) {
        this.chassisNo = chassisNo;
    }

    public Integer getServiceCount() {
        return serviceCount;
    }

    public void setServiceCount(Integer serviceCount) {
        this.serviceCount = serviceCount;
    }

    private boolean hasText(String value) {
        return value != null && !value.trim().isEmpty();
    }
}
