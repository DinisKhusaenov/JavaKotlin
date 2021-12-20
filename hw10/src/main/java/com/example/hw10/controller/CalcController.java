package com.example.hw10.controller;

import com.example.hw10.domain.CachedCalc;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalcController {
    private final CachedCalc cachedCalc;


    public CalcController(CachedCalc cachedCalc) {
        this.cachedCalc = cachedCalc;
    }


    @GetMapping("/add")
    @RequestMapping(value = "/add", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String add(@RequestParam(defaultValue = "0") String a, @RequestParam(defaultValue = "0") String b) {
        return cachedCalc.calculate(Double.parseDouble(a),Double.parseDouble(b),"+");
    }

    @GetMapping("/subtract")
    @RequestMapping(value = "/subtract", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String subtract(@RequestParam(defaultValue = "0") String a, @RequestParam(defaultValue = "0") String b) {
        return cachedCalc.calculate(Double.parseDouble(a),Double.parseDouble(b),"-");
    }

    @GetMapping("/multiply")
    @RequestMapping(value = "/multiply", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String multiply(@RequestParam(defaultValue = "1") String a, @RequestParam(defaultValue = "1") String b) {
        return cachedCalc.calculate(Double.parseDouble(a),Double.parseDouble(b),"*");
    }

    @GetMapping("/divide")
    @RequestMapping(value = "/divide", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String divide(@RequestParam(defaultValue = "1") String a, @RequestParam(defaultValue = "1") String b) {
        return cachedCalc.calculate(Double.parseDouble(a),Double.parseDouble(b),"/");
    }
}