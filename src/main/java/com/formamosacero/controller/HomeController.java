package com.formamosacero.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Home Controller for FORMAMOS ACERO SAC
 * Handles main navigation and dashboard rendering
 */
@Controller
public class HomeController {
    
    /**
     * Root path - redirects to dashboard
     * @return index view
     */
    @GetMapping("/")
    public String index() {
        return "index";
    }
    
    /**
     * Home path - shows main dashboard
     * @return index view
     */
    @GetMapping("/home")
    public String home() {
        return "index";
    }
    
    /**
     * Dashboard path - shows main dashboard
     * @return index view
     */
    @GetMapping("/dashboard")
    public String dashboard() {
        return "index";
    }
}
