package ru.larionov.sbertech.library.sberlibrary.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/error404")
    public String error404() {
        return "index";
    }
}
