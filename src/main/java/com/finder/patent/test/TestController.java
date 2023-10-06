package com.finder.patent.test;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @GetMapping(value = "/api/index")
    public ResponseEntity<String> index(){
        return ResponseEntity.ok().body(testService.getTestData());
    }
}
