package com.salahsongr.songr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Locale;

@Controller
public class Capitalized {
    @GetMapping("/capitalize/{inputVariable}")
    public String capitalized(Model model, @PathVariable("inputVariable") String inputVariable) {
        model.addAttribute("capital",inputVariable.toUpperCase(Locale.ROOT));
        return "capital";
    }
}
