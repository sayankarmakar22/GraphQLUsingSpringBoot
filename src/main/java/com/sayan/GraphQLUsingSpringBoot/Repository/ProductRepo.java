package com.sayan.GraphQLUsingSpringBoot.Repository;

import com.sayan.GraphQLUsingSpringBoot.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {
}
