package com.example.calcdemo;

import org.example.Calculator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class CalculatorController {
    private final Calculator calculator;

    public CalculatorController(Calculator calculator) {
        this.calculator = calculator;
    }

    @GetMapping("/sum")
    public String add(String a, String b) {
        var c = calculator.calculate(a, "+", b);
        return c.fold(i->i, Objects::toString);

    }
    @GetMapping("/differ")
    public String differ(String a, String b) {
        var c = calculator.calculate(a, "-", b);
        return c.fold(i->i, Objects::toString);

    }
    @GetMapping("/multiply")
    public String multiply(String a, String b) {
        var c = calculator.calculate(a, "*", b);
        return c.fold(i->i, Objects::toString);
    }
    @GetMapping("/div")
    public String div(String a, String b) {
        var c = calculator.calculate(a, "/", b);
        return c.fold(i->i, Objects::toString);

    }


}

