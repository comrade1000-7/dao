package org.example.controller;

import org.example.repository.DAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DAOController {
    @Autowired
    DAORepository repository;

    @GetMapping("/products")
    public List<String> getProduct(@RequestParam("name") String name) {
        List<String> productName = repository.getProductName(name);
        return productName;
    }
}