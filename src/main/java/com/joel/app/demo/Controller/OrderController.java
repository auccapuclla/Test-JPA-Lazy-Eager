package com.joel.app.demo.Controller;

import com.joel.app.demo.Repo.CustomerRepo;
import com.joel.app.demo.Repo.ProductRepo;
import com.joel.app.demo.dto.OrderRequest;
import com.joel.app.demo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private CustomerRepo customerRepo;

//    @Autowired
//    private ProductRepo productRepo;

    @PostMapping("/placeOrder")
    public Customer placeOrder(@RequestBody OrderRequest request){
        return customerRepo.save(request.getCustomer());
    }

    @GetMapping("/findAllOrders")
    public List<Customer> findAllOrders(){
        return customerRepo.findAll();
    }

}
