package customer;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private CustomerRepository repository;

    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/customer")
    List<Customer> getAll(){
        return repository.findAll();
    }

    @GetMapping("/customer/{id}")
    Customer get(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(()-> new CustomerNotFoundException(id));
    }

    @PostMapping("/customer")
    Customer save(@RequestBody Customer newCustomer){
        return repository.save(newCustomer);
    }

    @DeleteMapping("/customer/{id}")
    void delete(@PathVariable Long id){
        repository.deleteById(id);
    }
}
