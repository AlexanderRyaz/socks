package com.example.socks.service;

import com.example.socks.dto.SockDto;
import com.example.socks.model.Sock;
import com.example.socks.repository.SocksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.AttributeNotFoundException;
import java.util.List;

@Service
public class SockService {
    private SocksRepository socksRepository;

    @Autowired
    public SockService(SocksRepository socksRepository) {
        this.socksRepository = socksRepository;
    }

    @Transactional
    public void addSocks(SockDto sockDto) {
        List<Sock> allByColorAndCottonPart = socksRepository.findAllByColorAndCottonPart(sockDto.getColor(), sockDto.getCottonPart());
        if (allByColorAndCottonPart.isEmpty()) {
            Sock sock = new Sock();
            sock.setColor(sockDto.getColor());
            sock.setCottonPart(sockDto.getCottonPart());
            sock.setCount(sockDto.getCount());

            socksRepository.save(sock);
        } else {
            socksRepository.addSocks(sockDto.getColor(), sockDto.getCottonPart(), sockDto.getCount());
        }
    }

    @Transactional
    public void sellSocks(SockDto sockDto) {
        socksRepository.sellSocks(sockDto.getColor(), sockDto.getCottonPart(), sockDto.getCount());
    }

    public Long getSockCount(String color, String operation, Integer cottonPart) throws AttributeNotFoundException {
        switch (operation) {
            case "moreThan":
                return socksRepository.countAllByColorAndCottonPartGreaterThan(color, cottonPart);
            case "lessThan":
                return socksRepository.countAllByColorAndCottonPartLessThan(color, cottonPart);
            case "equal":
                return socksRepository.countAllByColorAndCottonPartEquals(color, cottonPart);
            default:
                throw new AttributeNotFoundException("Operation not found");
        }
    }
}
