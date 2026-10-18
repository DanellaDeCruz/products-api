package lk.ac.iit.products_api;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();
    private  Long nextId = 1L;

    public List<Product> getAllProducts(){

        return products;
    }

    public Product addProduct(Product product){
        product.setId(nextId++);
        products.add(product);
        return product;
    }

    //convert product to stream, then filter then check for the id, catch it and recovery code
    public Optional<Product> getProductById(Long id){
        return products.stream().filter(product->product.getId().equals(id)).findFirst();

        //option one
//      for(Product product: products){
//            if (product.getId().equals(id)){
//                return product;
//            }
//        }
//      return null;
    }
    public void deleteProduct(Long id){
        products.removeIf(p->p.getId().equals(id));
    }

    public List<Product> findByName(String name) {
        return products.stream()
                .filter(p -> p.getName().contains(name))
                .toList();
    }
}

