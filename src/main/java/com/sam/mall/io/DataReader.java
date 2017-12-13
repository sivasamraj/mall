package com.sam.mall.io;

import com.sam.mall.config.MallConfig;
import com.sam.mall.domain.Brand;
import com.sam.mall.domain.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Reader class which does all io operation to read the input data from files from disk
 *
 * @author Sivasamraj M
 */
@Component
public class DataReader {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MallConfig mallConfig;

    public MallConfig getMallConfig() {
        return mallConfig;
    }

    public void setMallConfig(MallConfig mallConfig) {
        this.mallConfig = mallConfig;
    }

    /**
     * reads and returns the categories from the input file
     *
     * @return list of categories
     */
    public List<Category> getCategories() {

        List<Category> categories = new ArrayList<>();
        try {
            File file = new File(mallConfig.getCategoriesFilePath());
            InputStream inputStream = new FileInputStream(file);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            categories = bufferedReader.lines().map(mapToCategory).collect(Collectors.toList());
            bufferedReader.close();

        } catch (IOException e) {
            logger.error("IOException occurred while reading the categories. Root cause - ", e);
        }

        logger.info("Categories read from the file - {}", categories);
        return categories;

    }

    /**
     * private function to map every line of the csv file to Category object
     */
    private Function<String, Category> mapToCategory = (line) -> {
        String[] tokens = line.split(",");
        Category category = new Category();
        if (tokens != null) {
            if (tokens[0] != null)
                category.setName(tokens[0]);
            if (tokens[1] != null)
                category.setDiscountPercent(Double.valueOf(tokens[1]));
            if (tokens.length > 2 && tokens[2] != null)
                category.setParentName(tokens[2]);
        }
        return category;
    };

    /**
     * reads and returns the list of brands from the input file
     *
     * @return list of brands
     */
    public List<Brand> getBrands() {

        List<Brand> brands = new ArrayList<>();

        try {
            File file = new File(mallConfig.getBrandsFilePath());
            InputStream inputStream = new FileInputStream(file);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            brands = bufferedReader.lines().map(mapToBrand).collect(Collectors.toList());
            bufferedReader.close();

        } catch (IOException e) {
            logger.error("IOException occurred while reading the brands. Root cause - ", e);
        }

        logger.info("Brands read from the file - {}", brands);
        return brands;

    }

    /**
     * pruvate function to map each line of the csv file to brand object
     */
    private Function<String, Brand> mapToBrand = (line) -> {
        String[] tokens = line.split(",");
        Brand brand = new Brand();
        if (tokens != null) {
            if (tokens[0] != null)
                brand.setName(tokens[0]);
            if (tokens.length > 1 && tokens[1] != null)
                brand.setDiscountPercent(Double.valueOf(tokens[1]));
        }
        return brand;
    };

    /**
     * reads and returns the list of items from the input file
     *
     * @return
     */
    public List<String> getInventoryItems() {
        List<String> inventoryItems = new ArrayList<>();

        try {
            File file = new File(mallConfig.getInputFilePath());
            InputStream inputStream = new FileInputStream(file);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String inventory = bufferedReader.lines().findFirst().get();
            int inventorySize = Integer.valueOf(inventory);
            inventoryItems = bufferedReader.lines().limit(inventorySize).collect(Collectors.toList());
            bufferedReader.close();

        } catch (NumberFormatException nfe) {
            logger.error("Error occured for invalid number given for the count of items. Please check the input file");

        } catch (IOException e) {
            logger.error("IOException occurred while reading the inventory items. Root cause - ", e);
        }

        logger.info("Items read from the file - {}", inventoryItems);

        return inventoryItems;
    }

    /**
     * reads and returns the cart information from the input file
     *
     * @return string of comma separated item ids
     */
    public List<String> getCarts() {
        List<String> carts = new ArrayList<>();
        try {
            File file = new File(mallConfig.getInputFilePath());
            InputStream inputStream = new FileInputStream(file);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String inventory = bufferedReader.lines().findFirst().get();
            int inventorySize = Integer.valueOf(inventory);
            String cart = bufferedReader.lines().skip(inventorySize + 1).findFirst().get();
            int cartSize = Integer.valueOf(cart);
            carts = bufferedReader.lines().limit(cartSize).collect(Collectors.toList());
            bufferedReader.close();

        } catch (NumberFormatException nfe) {
            logger.error("Error occured for invalid number given for the count of carts. Please check the input file");

        } catch (IOException e) {
            logger.error("IOException occurred while reading the cart items. Root cause - ", e);
        }

        logger.info("Cart items read from the file - {}", carts);
        return carts;
    }
}
