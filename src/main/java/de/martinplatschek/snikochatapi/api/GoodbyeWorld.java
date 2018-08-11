package de.martinplatschek.snikochatapi.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bye")
public class GoodbyeWorld {
    private final String MESSAGE = "Bye bye %s <3";

    @RequestMapping("")
    public String sayMessage(@RequestParam(value="name", defaultValue = "World") String name) {
        return String.format(MESSAGE, name);
    }
}