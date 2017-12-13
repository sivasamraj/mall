package com.sam.mall.io;

import com.sam.mall.Application;
import com.sam.mall.config.MallConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataReaderTest {

    @Autowired
    private DataReader reader;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void getCategories() throws Exception {
        assertNotNull(reader.getCategories());
        assertNotNull(reader.getCategories().get(0));
    }

    @Test
    public void getBrands() throws Exception {
        assertNotNull(reader.getBrands());
        assertNotNull(reader.getBrands().get(0));
    }

    @Test
    public void getInventoryItems() throws Exception {
        assertNotNull(reader.getInventoryItems());
        assertNotNull(reader.getInventoryItems().get(0));
    }

    @Test
    public void getCarts() throws Exception {
        assertNotNull(reader.getCarts());
        assertNotNull(reader.getCarts().get(0));
    }

}