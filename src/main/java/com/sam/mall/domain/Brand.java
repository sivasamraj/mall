package com.sam.mall.domain;

import org.springframework.stereotype.Component;

/**
 * This is the bean to store the Brand information
 *
 * @author Sivasamraj M
 */
@Component
public class Brand {
    private String name;
    private double discountPercent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Brand brand = (Brand) o;

        return name.equals(brand.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Brand{" +
                "name='" + name + '\'' +
                ", discountPercent=" + discountPercent +
                '}';
    }
}
