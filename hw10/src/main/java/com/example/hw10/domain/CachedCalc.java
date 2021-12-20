package com.example.hw10.domain;

import com.example.hw10.repository.CalcRepository;
import org.example.Calculator;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CachedCalc {
    private final Calculator calculator;
    private final CalcRepository calcRepository;

    @Autowired
    public CachedCalc(Calculator calculator, CalcRepository calculatorRepository) {
        this.calculator = calculator;
        this.calcRepository = calculatorRepository;
    }

    public String calculate(double a, double b, @NotNull String operator) {
        String result;
        Cache cache = calcRepository.findByFirstArgumentAndSecondArgumentAndOperator(String.valueOf(a), String.valueOf(b), operator);
        if (cache == null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            result = calculator.calculate(a, b, operator);
            calcRepository.save(new Cache(String.valueOf(a), String.valueOf(b), operator, result));
        } else {
            result = cache.getResult();
        }
        return result;
    }
}