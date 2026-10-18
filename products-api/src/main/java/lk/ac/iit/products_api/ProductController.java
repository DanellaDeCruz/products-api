package lk.ac.iit.products_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

//    @GetMapping("/{id}")
//    public Product getById(@PathVariable Long id){
//        return new Product(id,"Laptop", 999.999);
//    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }

    @GetMapping("/search")
    public List <Product> search(@RequestParam String name){
        return productService.findByName(name);
    }
}
