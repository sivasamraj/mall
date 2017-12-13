package com.sam.mall.domain;

import org.springframework.stereotype.Component;

/**
 * The class which represents the indivual item or product
 *
 * @author Sivasamraj M
 */
@Component
public class Item {
    private int id;
    private Brand brand;
    private Category category;
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Calculates the final discount of the item by comparing the brand discount and the category discount
     *
     * @return double discountPrice
     */
    public double getDiscountPrice() {
        return price * (100 - (brand.getDiscountPercent() > category.getDiscountPercent() ?
                brand.getDiscountPercent() : category.getDiscountPercent())) / 100;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", brand=" + brand.getName() +
                ", category=" + category.getName() +
                ", price=" + price +
                ", discountedPrice=" + getDiscountPrice() +
                '}';
    }
}
