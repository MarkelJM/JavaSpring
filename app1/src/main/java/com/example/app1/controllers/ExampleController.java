package com.example.app1.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping(path = "example")
public class ExampleController {

    @RequestMapping(path = "hello")   //http://...../example/hello
    @ResponseBody  //para devolver datos; @Controller devuelve "html" y otros devuelven otras cosas
    public String hello(){
        return "Hi :)";
    }

    public void serverDate(){

    }
    @RequestMapping(path = "time")
    @ResponseBody
    public LocalDateTime localDateTime(){
        return LocalDateTime.now();
    }



}



