package project.resource;

import org.junit.jupiter.api.Test;
import project.domain.product.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductResourceTest extends JAXRSResourceBase {

    @Test
    void getAllProducts() {
        assertOK(get("/products"));
    }

    @Test
    void getProduct() {
        assertOK(get("/products/1"));
        assertNoContent(get("/products/10086"));
        Product book = get("/products/1").readEntity(Product.class);
        assertEquals("java core）", book.getTitle());
    }

    @Test
    void updateProduct() {
        final Product book = get("/products/1").readEntity(Product.class);
        book.setTitle("java core");
        assertForbidden(put("/products", book));

        Product modifiedBook = get("/products/1").readEntity(Product.class);
        assertEquals("java core", modifiedBook.getTitle());
    }
}
