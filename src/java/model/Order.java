/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class Order {

    private int id;
    private String name;
    private String email;
    private String city;
    private int postalCode;
    private String address;
    private int totalPaid;
    private LocalDateTime dateCreated;
    private ArrayList<Integer> quantity;
    private ArrayList<Integer> cellphoneId;

    public Order() {
    }

    public Order(int id, String name, String email, String city, int postalCode, String address, int totalPaid, LocalDateTime dateCreated, ArrayList<Integer> quantity, ArrayList<Integer> cellphoneId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.city = city;
        this.postalCode = postalCode;
        this.address = address;
        this.totalPaid = totalPaid;
        this.dateCreated = dateCreated;
        this.quantity = quantity;
        this.cellphoneId = cellphoneId;
    }

    public Order(String name, String email, String city, int postalCode, String address, int totalPaid, LocalDateTime dateCreated, ArrayList<Integer> quantity, ArrayList<Integer> cellphoneId) {
        this.name = name;
        this.email = email;
        this.city = city;
        this.postalCode = postalCode;
        this.address = address;
        this.totalPaid = totalPaid;
        this.dateCreated = dateCreated;
        this.quantity = quantity;
        this.cellphoneId = cellphoneId;
    }

    

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(int totalPaid) {
        this.totalPaid = totalPaid;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public ArrayList<Integer> getQuantity() {
        return quantity;
    }

    public void setQuantity(ArrayList<Integer> quantity) {
        this.quantity = quantity;
    }

    

    public ArrayList<Integer> getCellphoneId() {
        return cellphoneId;
    }

    public void setCellphoneId(ArrayList<Integer> cellphoneId) {
        this.cellphoneId = cellphoneId;
    }

    

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = dateCreated.format(formatter);

        return "Order{"
                + "id='" + id + '\''
                + ", name='" + name + '\''
                + ", email='" + email + '\''
                + ", city='" + city + '\''
                + ", postalCode=" + postalCode
                + ", address='" + address + '\''
                + ", totalPaid=" + totalPaid
                + ", dateCreated=" + formattedDate
                + ", quantity=" + quantity
                + ", cellphoneId=" + cellphoneId
                + '}';
    }

}
