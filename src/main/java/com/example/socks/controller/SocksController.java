package com.example.socks.controller;

import com.example.socks.dto.SockDto;
import com.example.socks.service.SockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/socks")
public class SocksController {
    private SockService sockService;

    @Autowired
    public SocksController(SockService sockService) {
        this.sockService = sockService;
    }

    @PostMapping("income")
    public ResponseEntity<String> addSocks(@RequestBody SockDto sockDto, Long count) {
        sockService.addSocks(sockDto, count);
        return new ResponseEntity<>("Добавлено " + count + " носков", HttpStatus.OK);
    }

    @PostMapping("outcome")
    public ResponseEntity<String> sellSocks(@RequestBody SockDto sockDto, Long count) {
        sockService.sellSocks(sockDto, count);
        return new ResponseEntity<>("Отпущено со склада " + count + " носков", HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Long> getSockCount(@RequestParam("color") String color,
                                             @RequestParam("operation") String operation,
                                             @RequestParam("cottonPart") Integer cottonPart) {
        Long sockCount = sockService.getSockCount(color, operation, cottonPart);
        return new ResponseEntity<>(sockCount, HttpStatus.OK);
    }
}
