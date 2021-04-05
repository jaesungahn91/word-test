package com.js.vocatest.controller;

import com.js.vocatest.repository.VocaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TestController {

    private final VocaRepository vocaRepository;

    @GetMapping("/test")
    public Object testMethod(){
        return vocaRepository.findAll();
    }

    @GetMapping("/test2")
    public Object testMethod2(){
        throw new RuntimeException("런타임 에러 테스트");
    }
}
