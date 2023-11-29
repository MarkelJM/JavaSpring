package com.example.app1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PagesControllers {
    //metodo para solicitar una pagina usando Thymeleaf
    public String pageHome(){
        return  "home";
    }
}
