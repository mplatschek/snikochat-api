package de.martinplatschek.snikochatapi.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloWorld {
    private final String MESSAGE = "Hello %s, that's snikochatapi";

    @RequestMapping("")
    public String sayMessage(@RequestParam(value="name", defaultValue = "World") String name) {
        return String.format(MESSAGE, name);
    }
}
