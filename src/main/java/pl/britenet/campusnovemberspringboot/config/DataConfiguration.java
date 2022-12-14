package pl.britenet.campusnovemberspringboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.britenet.campusapiapp.database.DatabaseService;
import pl.britenet.campusapiapp.service.ProductService;

@Configuration
public class DataConfiguration {

    private final DatabaseService databaseService;

    @Autowired
    public DataConfiguration(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    @Bean
    public ProductService getProductService() {
        return new ProductService(this.databaseService);
    }

}
