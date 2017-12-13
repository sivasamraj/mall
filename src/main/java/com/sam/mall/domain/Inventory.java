package com.sam.mall.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * The class which holds the inventory of items, brands and the categories of the mall
 *
 * @author Sivasamraj M
 */
@Component
public class Inventory extends Cart {

    private List<Brand> brands;

    private List<Category> categories;

    public List<Brand> getBrands() {
        return brands;
    }

    public void setBrands(List<Brand> brands) {
        this.brands = brands;
    }

    public Brand getBrand(String name) {
        return this.brands.stream().filter(e -> e.getName().equalsIgnoreCase(name)).findFirst().get();
    }

    public void addBrand(Brand brand) {
        if (this.brands == null)
            this.brands = new ArrayList<>();
        this.brands.add(brand);
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Category getCategory(String name) {
        return this.categories.stream().filter(e -> e.getName().equalsIgnoreCase(name)).findFirst().get();
    }

    public void addCategory(Category category) {
        if (this.categories == null) {
            this.categories = new ArrayList<>();
        }
        this.categories.add(category);
    }
}
