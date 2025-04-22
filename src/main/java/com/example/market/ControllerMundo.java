package com.example.market;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saludar")
public class ControllerMundo {

    @GetMapping("/hola")
    public String Saludar(){
        return "hola mundos";
    }
}
