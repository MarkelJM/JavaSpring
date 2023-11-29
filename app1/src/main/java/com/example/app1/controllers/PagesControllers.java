package com.example.app1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("page")
public class PagesControllers {
    //metodo para solicitar una pagina usando Thymeleaf


    @GetMapping
    public String pageHome(Model model){
        model.addAttribute("nombre", "Markel");
        return  "home";
    }


    /*
    //2.opcion

    @GetMapping
    public String pageHome2(){
        var model = new ModelAndView();
        model.addObject("nombre", "Markel";
        return  "home";
    }
    */

}
