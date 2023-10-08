package com.sayan.GraphQLUsingSpringBoot.Controllers;

import com.sayan.GraphQLUsingSpringBoot.Model.Product;
import com.sayan.GraphQLUsingSpringBoot.Services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class MainController {
    @Autowired
    private ProductServices productServices;
    @GetMapping("/{id}")
    public Product view(@PathVariable int id){
        return productServices.view(id);
    }
    @PostMapping
    public Product save(@RequestBody Product product){
        return productServices.save(product);
    }
    @PutMapping("/update")
    public Product update(@RequestBody Product product){
        return productServices.update(product);
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        return productServices.delete(id);
    }
}
