package com.salahsongr.songr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Hello {
    @GetMapping("/hello")
    public String RenderHello(Model model) {
        model.addAttribute("message","Hello World");
        return "helloWorld";
    }
}
