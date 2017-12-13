package com.sam.mall.service;

import com.sam.mall.domain.Cart;
import com.sam.mall.domain.Category;
import com.sam.mall.domain.Inventory;
import com.sam.mall.domain.Item;
import com.sam.mall.io.DataReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Implemetation for the MallService interface
 *
 * @author Sivasamraj M
 */
@Service
public class MallServiceImpl implements MallService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Inventory inventory;

    private List<Cart> carts = new ArrayList<>();

    @Autowired
    private DataReader dataReader;

    /**
     * loads the categories from the reader into the inventory
     */
    @Override
    public void loadCategories() {
        inventory.setCategories(dataReader.getCategories());
        for (Category category : inventory.getCategories()) {
            if (category.getParentName() != null) {
                category.setParent(inventory.getCategory(category.getParentName()));
            }
        }
        logger.info("Categories - {}", inventory.getCategories());
    }

    /**
     * loads the brands from the reader into the inventory
     */
    @Override
    public void loadBrands() {
        inventory.setBrands(dataReader.getBrands());
        logger.info("Brands - {}", inventory.getBrands());
    }

    /**
     * loads the items from the reader into the inventory
     */
    @Override
    public void loadInventorytems() {
        List<String> items = dataReader.getInventoryItems();
        for (String itemvalue : items) {
            String[] itemProps = itemvalue.split(",");
            if (itemProps != null) {
                Item item = new Item();
                if (itemProps[0] != null)
                    item.setId(Integer.valueOf(itemProps[0]));
                if (itemProps[1] != null)
                    item.setBrand(inventory.getBrand(itemProps[1]));
                if (itemProps[2] != null)
                    item.setCategory(inventory.getCategory(itemProps[2]));
                if (itemProps[3] != null)
                    item.setPrice(Double.valueOf(itemProps[3]));
                inventory.addItem(item);
            }
        }
        logger.info("Inventory Items - {}", inventory.getItems());
    }

    /**
     * loads the cart items from the reader into the cart object
     */
    @Override
    public void loadCarts() {
        List<String> cartsdata = dataReader.getCarts();
        for (String cartdata : cartsdata) {
            String[] itemids = cartdata.split(",");
            if (itemids != null) {
                Cart cart = new Cart();
                for (int i = 0; i < itemids.length; i++) {
                    cart.addItem(inventory.getItem(Integer.valueOf(itemids[i])));
                }
                carts.add(cart);
            }
        }
    }

    /**
     * calculates the cartwise discount and log it
     */
    @Override
    public void calculateDiscount() {
        int counter = 1;
        logger.info("-----------------------------------------------------------");
        for (Cart cart : carts) {
            logger.info("Cart {} final discounted price : Rs.{}", counter, cart.getDiscountedPrice());
            counter++;
        }

        logger.info("-----------------------------------------------------------");
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }
}
