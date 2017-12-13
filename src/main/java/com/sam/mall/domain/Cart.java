package com.sam.mall.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * The class to represent the customer Cart containing the items
 *
 * @author Sivasamraj M
 */
@Component
public class Cart {

    protected List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Item getItem(int id) {
        return items.stream().filter(e -> e.getId() == id).findAny().orElse(null);
    }

    public void addItem(Item item) {
        if (this.items == null)
            this.items = new ArrayList<>();
        this.items.add(item);
    }

    /**
     * gets the total discounted price of the cart by summing up the same for individual items in the cart
     *
     * @return double discountedPrice
     */
    public double getDiscountedPrice() {
        double discountedPrice = 0;
        for (Item item : items) {
            discountedPrice += item.getDiscountPrice();
        }
        return discountedPrice;
    }
}
