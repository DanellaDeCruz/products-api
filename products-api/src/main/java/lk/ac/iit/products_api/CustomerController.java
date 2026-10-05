package lk.ac.iit.products_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @GetMapping("/{id}")
    public Customer getById(Long id){

        Address address = new Address("115 New Cavendis Street", "London", "W1W 6UW");

        return new Customer(id, "Ada Lovelace", "ada@example.com", address);
    }
}
