package com.example.socks.repository;

import com.example.socks.model.Sock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SocksRepository extends JpaRepository<Sock, Long> {
    Long countAllByColorAndCottonPartGreaterThan(String color, Integer cottonPart);

    Long countAllByColorAndCottonPartLessThan(String color, Integer cottonPart);

    Long countAllByColorAndCottonPartEquals(String color, Integer cottonPart);

    @Modifying
    @Query("update Sock s set s.count = s.count - :count where s.color = :color and s.cottonPart = :cottonPart")
    void sellSocks(@Param("color") String color, @Param("cottonPart") Integer cottonPart, @Param("count") Long count);

}
