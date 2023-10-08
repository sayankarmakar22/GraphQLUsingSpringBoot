package com.sayan.GraphQLUsingSpringBoot.Services;

import com.sayan.GraphQLUsingSpringBoot.Model.Product;
import com.sayan.GraphQLUsingSpringBoot.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServices {
    @Autowired
    private ProductRepo productRepo;

    public Product save(Product product){
        return productRepo.save(product);
    }
    public Product view(int id){
        return productRepo.findById(id).orElse(null);
    }
    public Product update(Product product){
        if(productRepo.existsById(product.getId())){
            Product foundProduct = productRepo.findById(product.getId()).orElseThrow(()-> new RuntimeException("product not found"));
            foundProduct.setName(product.getName());
            foundProduct.setPrice(product.getPrice());
            return productRepo.save(foundProduct);
        }
        throw new RuntimeException("something went with the entered product id");
    }
    public String delete(int id){
        productRepo.deleteById(id);
        return "deleted " + id;
    }
}
