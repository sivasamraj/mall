package com.sam.mall.service;

import com.sam.mall.domain.Cart;

import java.util.List;

/**
 * Interface for the mall service operations
 */
public interface MallService {
    public void loadCategories();
    public void loadBrands();
    public void loadInventorytems();
    public void loadCarts();
    public void calculateDiscount();
    public List<Cart> getCarts();
}
