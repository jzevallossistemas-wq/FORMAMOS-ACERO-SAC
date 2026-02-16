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

    @GetMapping("/preorden")
    public String preordenes() {
        return "preordenes";
    }

    @GetMapping("/solicitud-efectivo")
    public String solicitudEfectivo() {
        return "solicitud-efectivo";
    }

    @GetMapping("/solicitud-viatico")
    public String solicitudViatico() {
        return "solicitud-viatico";
    }

    @GetMapping("/cotizacion-pasajes")
    public String cotizacionPasajes() {
        return "cotizacion-pasajes";
    }

    @GetMapping("/comparativo-precios")
    public String comparativoPreciosPasajes() {
        return "comparativo-precios";
    }
}