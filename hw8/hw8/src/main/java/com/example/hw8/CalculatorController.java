package com.example.hw8;

import org.example.Calculator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    private Calculator calculator;


    public CalculatorController(Calculator calculator){
        this.calculator = calculator;
    }

    @GetMapping("/add")
    public String add(@RequestParam(defaultValue = "0") String a, @RequestParam(defaultValue = "0") String b) {
        return String.valueOf(calculator.add(Integer.parseInt(a), Integer.parseInt(b)));
    }

    @GetMapping("/subtract")
    public String subtract(@RequestParam(defaultValue = "0") String a, @RequestParam(defaultValue = "0") String b) {
        return String.valueOf(calculator.subtract(Integer.parseInt(a), Integer.parseInt(b)));
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam(defaultValue = "1") String a, @RequestParam(defaultValue = "1") String b) {
        return String.valueOf(calculator.multiply(Integer.parseInt(a), Integer.parseInt(b)));
    }

    @GetMapping("/divide")
    public String divide(@RequestParam(defaultValue = "1") String a, @RequestParam(defaultValue = "1") String b) {
        if (Integer.parseInt(b) == 0) return "Нельзя делить на 0";
        else return String.valueOf(calculator.divide(Integer.parseInt(a), Integer.parseInt(b)));
    }

}