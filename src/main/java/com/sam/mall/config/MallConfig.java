package com.sam.mall.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class to hold the location for all input files
 *
 * @author Sivasamraj M
 */
@Configuration
public class MallConfig {

    @Value("${file.path.categories}")
    private String categoriesFilePath;

    @Value("${file.path.brands}")
    private String brandsFilePath;

    @Value("${file.path.input}")
    private String inputFilePath;

    public String getCategoriesFilePath() {
        return categoriesFilePath;
    }

    public void setCategoriesFilePath(String categoriesFilePath) {
        this.categoriesFilePath = categoriesFilePath;
    }

    public String getBrandsFilePath() {
        return brandsFilePath;
    }

    public void setBrandsFilePath(String brandsFilePath) {
        this.brandsFilePath = brandsFilePath;
    }

    public String getInputFilePath() {
        return inputFilePath;
    }

    public void setInputFilePath(String inputFilePath) {
        this.inputFilePath = inputFilePath;
    }
}
