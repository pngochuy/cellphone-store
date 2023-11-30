/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class Cellphone {
    private int id;
    private String title;
    private Category category;
    private String image;
    private String description;
    private int price;

    public Cellphone() {
    }

    public Cellphone(String title, Category category, String image, String description, int price) {
        this.title = title;
        this.category = category;
        this.image = image;
        this.description = description;
        this.price = price;
    }

    public Cellphone(int id, String title, Category category, String listImage, String description, int price) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.image = listImage;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Cellphone{" + "id=" + id + ", title=" + title + ", category=" + category + ", image=" + image + ", description=" + description + ", price=" + price + '}';
    }

    
}
