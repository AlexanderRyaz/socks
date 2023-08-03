package com.example.socks.service;

import com.example.socks.dto.SockDto;
import com.example.socks.model.Sock;
import com.example.socks.repository.SocksRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SockService {
    private SocksRepository socksRepository;

    @Autowired
    public SockService(SocksRepository socksRepository) {
        this.socksRepository = socksRepository;
    }

    public void addSocks(SockDto sockDto, Long count) {
        Sock sock = new Sock();
        sock.setColor(sockDto.getColor());
        sock.setCottonPart(sockDto.getCottonPart());
        sock.setCount(count);

        socksRepository.save(sock);
    }

    public void sellSocks(SockDto sockDto, Long count) {

    }

    public Long getSockCount(String color, String operation, Integer cottonPart) {
        return null;
    }
}
