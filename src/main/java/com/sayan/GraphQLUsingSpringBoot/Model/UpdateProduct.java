package com.sayan.GraphQLUsingSpringBoot.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateProduct {
    private int id;
    private String name;
    private int price;
}
