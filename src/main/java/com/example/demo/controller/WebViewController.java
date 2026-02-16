package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebViewController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/cliente")
    public String clientes() {
        return "clientes";
    }

    @GetMapping("/proveedor")
    public String proveedores() {
        return "proveedores";
    }

    @GetMapping("/orden")
    public String ordenes() {
        return "ordenes";
    }
}