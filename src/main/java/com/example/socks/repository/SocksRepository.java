package com.example.socks.repository;

import com.example.socks.model.Sock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocksRepository extends JpaRepository<Sock,Long> {
}
