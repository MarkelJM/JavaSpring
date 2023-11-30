package com.example.app1.controllers;

import com.example.app1.models.CompraForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("page")
public class PagesControllers {
    //metodo para solicitar una pagina usando Thymeleaf


    @GetMapping
    public String pageHome(Model model){
        model.addAttribute("nombre", "Markel");
        //model.addAttribute("nombres", List.of("Python", "Java", "SQL", "Swift")); //Añadimos Lista
        model.addAttribute("nombres", Map.of(1, "Java", 2, "Swift",3, "SQL", 4, "Python")); //Añadimos Lista

        return  "home";
    }

    @GetMapping("compra")
    public String purchaseItem(Model model){
        model.addAttribute("compra", new CompraForm(10.0, ""));
        return  "compra";
    }

    @PostMapping("compra")
    public String purchaseItem(Model model, @ModelAttribute CompraForm compra, Errors error){
        if(compra.getPrecio() < 1.0){
            error.rejectValue("precio", "", "");
        }

        if(error.hasErrors()){
            model.addAttribute("compra",compra);
            return  "compra";
        }
        System.out.println(compra);
        return "redirect:compra";
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
