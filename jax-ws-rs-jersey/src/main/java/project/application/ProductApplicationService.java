package project.application;

import jakarta.inject.Named;
import project.domain.product.Product;

@Named
public class ProductApplicationService {

    // @Inject
    // private ProductService service;
    // @Inject
    // private StockpileService stockpileService;

    public Iterable<Product> getAllProducts() {
        return null;
    }
}
