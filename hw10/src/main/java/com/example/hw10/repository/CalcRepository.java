package com.example.hw10.repository;

import com.example.hw10.domain.Cache;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalcRepository extends JpaRepository<Cache,Integer> {
    Cache findByFirstArgumentAndSecondArgumentAndOperator(String firstArgument, String secondArgument, String operator);
}
