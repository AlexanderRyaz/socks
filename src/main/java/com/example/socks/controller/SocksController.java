package com.example.socks.controller;

import com.example.socks.dto.SockDto;
import com.example.socks.service.SockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.AttributeNotFoundException;

@RestController
@RequestMapping("api/socks")
public class SocksController {
    private SockService sockService;

    @Autowired
    public SocksController(SockService sockService) {
        this.sockService = sockService;
    }

    @PostMapping("income")
    public ResponseEntity<String> addSocks(@RequestBody SockDto sockDto) {
        sockService.addSocks(sockDto);
        return new ResponseEntity<>("Добавлено " + sockDto.getCount() + " носков", HttpStatus.OK);
    }

    @PostMapping("outcome")
    public ResponseEntity<String> sellSocks(@RequestBody SockDto sockDto) {
        sockService.sellSocks(sockDto);
        return new ResponseEntity<>("Отпущено со склада " + sockDto.getCount() + " носков", HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Long> getSockCount(@RequestParam("color") String color,
                                             @RequestParam("operation") String operation,
                                             @RequestParam("cottonPart") Integer cottonPart) throws AttributeNotFoundException {
        Long sockCount = sockService.getSockCount(color, operation, cottonPart);
        return new ResponseEntity<>(sockCount, HttpStatus.OK);
    }
}
