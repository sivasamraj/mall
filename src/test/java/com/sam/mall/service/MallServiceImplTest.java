package com.sam.mall.service;

import com.sam.mall.domain.Inventory;
import com.sam.mall.io.DataReader;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.crypto.Data;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MallServiceImplTest {

    @Autowired
    private MallService mallService;

    @Autowired
    private Inventory inventory;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void loadCategories() throws Exception {
        mallService.loadCategories();
        assertNotNull(inventory.getCategories());
        assertNotNull(inventory.getCategories().get(0));
    }

    @Test
    public void loadBrands() throws Exception {
        mallService.loadBrands();
        assertNotNull(inventory.getBrands());
        assertNotNull(inventory.getBrands().get(0));
    }

    @Test
    public void loadInventorytems() throws Exception {
        mallService.loadInventorytems();
        assertNotNull(inventory.getItems());
        assertNotNull(inventory.getItems().get(0));
    }

    @Test
    public void loadCarts() throws Exception {
        mallService.loadCarts();
        assertNotNull(mallService.getCarts());
        assertNotNull(mallService.getCarts().get(0));
    }

    @Test
    public void calculateDiscount() throws Exception {
    }

}