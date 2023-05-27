package edu.internetstore.internetstore.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class HomeRestController {

    @GetMapping(value = {"/", "/hello/{name}"})
    public String home(@PathVariable(value = "name", required = false) String name) { // /name
        return Objects.isNull(name) ? "Hello, world!" : "Hello, " + name +" !";
    }

    @GetMapping(value = "/home")
    public String homeWithParam(@RequestParam(value = "name", defaultValue = "world!" ) String name) {
        return "Hello, " + name +" !";
    }
}
