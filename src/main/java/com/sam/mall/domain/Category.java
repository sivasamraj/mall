package com.sam.mall.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * This is the bean to store Category information
 *
 * @author Sivasamraj M
 */
@Component
public class Category {

    private String name;

    private double discountPercent;

    @Autowired
    private Category parent;

    private String parentName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * gets the maximum discount comparing the current and ancestor categories
     *
     * @return double discountPercent
     */
    public double getDiscountPercent() {
        double finalDiscount = this.discountPercent;
        if (parent.discountPercent > finalDiscount) {
            finalDiscount = parent.discountPercent;
        }
        return finalDiscount;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        return name.equals(category.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", discountPercent=" + discountPercent +
                ", parent=" + parent +
                '}';
    }
}
