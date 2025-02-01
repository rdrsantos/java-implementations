package com.bbb.controller;

import com.bbb.dto.VotoRequest;
import com.bbb.service.VotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/voto")
public class VotoController {

    private final VotoService service;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping
    public void processaVoto(@RequestBody VotoRequest request) {
        service.processaVoto(request);
    }
}
