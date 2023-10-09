package com.sayan.GraphQLUsingSpringBoot.Controllers;

import com.sayan.GraphQLUsingSpringBoot.Model.Product;
import com.sayan.GraphQLUsingSpringBoot.Model.ProductIn;
import com.sayan.GraphQLUsingSpringBoot.Model.UpdateProduct;
import com.sayan.GraphQLUsingSpringBoot.Services.ProductServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Controller
public class MainController {
    private Logger log = LoggerFactory.getLogger(MainController.class);
    @Autowired
    private ProductServices productServices;
    @QueryMapping("getProduct")
    public Product view(@Argument int id){
        return productServices.view(id);
    }
    @QueryMapping("allProduct")
    public List<Product> all(){
        return productServices.allProduct();
    }
    @MutationMapping("save")
    public Product save(@Argument ProductIn product){
        log.info(product.toString());
        Product product1 = new Product();
        product1.setId((int) (Math.random()*1000));
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        return productServices.save(product1);
    }
    @MutationMapping("update")
    public Product update(@Argument UpdateProduct product){
        log.info(product.toString());
        Product product1 = new Product();
        product1.setId(product.getId());
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        return productServices.update(product1);
    }
    @MutationMapping("delete")
    public String delete(@Argument int id){
        return productServices.delete(id);
    }
}
