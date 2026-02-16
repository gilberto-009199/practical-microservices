package com.gilberto009199.microservices.client.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RootController {

    @Value("${config.dado}")
    private String dado;

    @GetMapping
    public String get(){
        return "Dados: "+ dado;
    }

}
