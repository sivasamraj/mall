package com.sam.mall;

import com.sam.mall.service.MallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

/**
 * Spring Boot Application of Shopping Mall
 *
 * @author Sivasamraj M
 */
@SpringBootApplication
public class Application {
    @Autowired
    private MallService mallService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * executes the service operation in the sequence
     */
    @PostConstruct
    public void execute() {
        mallService.loadCategories();
        mallService.loadBrands();
        mallService.loadInventorytems();
        mallService.loadCarts();
        mallService.calculateDiscount();

    }
}
